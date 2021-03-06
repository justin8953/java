import java.util.Arrays; 

/* Store a triangle as three lengths, and provide information about it. Any
three ints are allowed, even if the result is not a 'legal' triangle. */

class Triangle {
    private int a, b, c;
    // Create a triangle object from three lengths
    Triangle(int a0, int b0, int c0) {
        a = a0; b = b0; c = c0;
    }

    // Classify a triangle from the lengths
    Type classify() {
        if(is_illegal(a, b, c)||is_overflow(a,b,c)){return Type.Illegal;}
        else if(is_impossible(a,b,c)){return Type.Impossible;}
        else if(is_Equilateral(a, b, c)){return Type.Equilateral;}
        else if(is_Isosceles(a, b, c)){return Type.Isosceles;}
        else if(is_Right(a, b, c)){return Type.Right;}
        else if(is_Flat(a, b, c)){return Type.Flat;}
        else if(is_Scalene(a, b, c)){return Type.Scalene;}
        return Type.Illegal;
    }
    private boolean is_illegal(int a0, int b0, int c0){
        if(a0<=0 || b0<=0 || c0<=0){return true;}
        return false;
    }
    private boolean is_impossible(int a0, int b0, int c0){
        long [] lengths  = {a0, b0, c0};
        Arrays.sort(lengths);
        if(lengths[2]>lengths[0]+lengths[1]){return true;}
        return false;
    }
    private boolean is_Flat(int a0, int b0, int c0){
        long [] lengths  = {a0, b0, c0};
        Arrays.sort(lengths);
        if(lengths[2]==lengths[0]+lengths[1]){return true;}
        return false;
    }
    private boolean is_Equilateral(int a0, int b0, int c0){
        if(a0==b0 && b0==c0){return true;}
        return false;
    }
    private boolean is_Isosceles(int a0, int b0, int c0){
        long[] lengths  = {a0, b0, c0};
        Arrays.sort(lengths);
        if(((lengths[0]+lengths[1])!=lengths[2]) && (a0==b0 || a0==c0||b0==c0)){return true;}
        return false;
    }
    private boolean is_Scalene(int a0, int b0, int c0){
        if(a0!=b0 && a0!=c0 && b0!=c0){return true;}
        return false;
    }
    private boolean is_Right(int a0, int b0, int c0){
        long[] lengths  = {a0, b0, c0};
        Arrays.sort(lengths);
        if ((lengths[2]*lengths[2])==(lengths[0]*lengths[0]+lengths[1]*lengths[1])){return true;}
        return false;
    }
    private boolean is_overflow(int a0, int b0, int c0){
        if (a0>Integer.MAX_VALUE||b0>Integer.MAX_VALUE||c0>Integer.MAX_VALUE){return true;}
        return false;
    }

    // ---------- Testing -----------

    public static void main(String[] args) {
        Triangle program = new Triangle(0, 0, 0);
        program.run();
    }

    // Run the tests
    private void run() {
        boolean testing = false;
        assert(testing = true);
        if (! testing) throw new Error("Use java -ea Triangle");
        testEquilateral();
        testIsosceles();
        testScalene();
        testRight();
        testFlat();
        testImpossible();
        testZero();
        testNegative();
        testOverflow();
        System.out.println("All tests pass");
    }

    // Check that a triangle with given lengths has the given type.
    private boolean check(int a0, int b0, int c0, Type t) {
        a = a0; b = b0; c = c0;
        return classify() == t;
    }
    // Equilateral: all equal
    private void testEquilateral() {
        assert(check(8, 8, 8, Type.Equilateral));
    }

    // Isosceles: any two equal
    private void testIsosceles() {
        assert(check(5, 5, 3, Type.Isosceles));
        assert(check(5, 3, 5, Type.Isosceles));
        assert(check(3, 5, 5, Type.Isosceles));
        assert(check(5, 5, 7, Type.Isosceles));
        assert(check(5, 7, 5, Type.Isosceles));
        assert(check(7, 5, 5, Type.Isosceles));
    }

    // Scalene: all three different (but not special)
    private void testScalene() {
        assert(check(12, 14, 15, Type.Scalene));
        assert(check(14, 12, 15, Type.Scalene));
        assert(check(12, 15, 14, Type.Scalene));
        assert(check(14, 15, 12, Type.Scalene));
        assert(check(15, 12, 14, Type.Scalene));
        assert(check(15, 14, 12, Type.Scalene));
    }

    // Right-angled: Pythagoras's theorem
    private void testRight() {
        assert(check(5, 12, 13, Type.Right));
        assert(check(12, 5, 13, Type.Right));
        assert(check(5, 13, 12, Type.Right));
        assert(check(12, 13, 5, Type.Right));
        assert(check(13, 5, 12, Type.Right));
        assert(check(13, 12, 5, Type.Right));
    }

    // Flat: two sides add up to the third
    private void testFlat() {
        assert(check(7, 7, 14, Type.Flat));
        assert(check(7, 14, 7, Type.Flat));
        assert(check(14, 7, 7, Type.Flat));
        assert(check(7, 9, 16, Type.Flat));
        assert(check(7, 16, 9, Type.Flat));
        assert(check(9, 16, 7, Type.Flat));
        assert(check(16, 7, 9, Type.Flat));
    }

    // Impossible: two sides add up to less than the third
    private void testImpossible() {
        assert(check(2, 3, 13, Type.Impossible));
        assert(check(2, 13, 3, Type.Impossible));
        assert(check(13, 2, 3, Type.Impossible));
    }

    // Illegal: a side is zero
    private void testZero() {
        assert(check(0, 0, 0, Type.Illegal));
        assert(check(0, 10, 12, Type.Illegal));
        assert(check(10, 0, 12, Type.Illegal));
        assert(check(10, 12, 0, Type.Illegal));
    }

    // Illegal: a side is negative
    private void testNegative() {
        assert(check(-1, -1, -1, Type.Illegal));
        assert(check(-1, 10, 12, Type.Illegal));
        assert(check(10, -1, 12, Type.Illegal));
        assert(check(10, 12, -1, Type.Illegal));
    }

    // Overflow: check that the program doesn't have overflow problems due to
    // using int, float or double. If there are overflow problems, the program
    // will say Equilateral.
    private void testOverflow() {
        assert(check(1100000000, 1705032704, 1805032704, Type.Scalene));
        assert(check(2000000001, 2000000002, 2000000003, Type.Scalene));
        assert(check(150000002, 666666671, 683333338, Type.Scalene));
    }
}
