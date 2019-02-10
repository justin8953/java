## JAVA NOTE

### Class
1. Class is a `type` as well as a `module`
2. Class contains fields and methods

### Data Type
1. Comment Using: 
 - `/* */` or `//`
2. Declarion:
 - Array:
   `int [] arr; //declare
	 arr = new int [3] // allocate size 
	 arr[0] = 5, arr[1] = 8, arr[2] = 7 //fill
	 int [] arr2 = { 5, 8, 7 } // all in one 
	`


### Access Level

| Modifier    | Class | Package | Subclass | World |
| :---        | :---: | :---:   | :---:    | :---: |
| Public      | Y     | Y       | Y        | Y     |
| Protected   | Y     | Y       | Y        | N     |
| No Modifier | Y     | Y       | N        | N     |
| Private     | Y     | N       | N        | N

### Clean Code
1. Comment:
 - Go at the top of a `class` or just before a `method`
 - Explain what `it is for or how to use it`, not how it works
