/* A puzzle entity in an adventure game. It has a custom verb which it responds
to, e.g. "open".  It has an item which the player must have in order to solve
the puzzle, e.g. a key.  It has a failure message printed out if the player
doesn't have the needed item, and a success message if the puzzle is solved.
When the puzzle is solved, some entities are added to the current place,
e.g. things or exits which are now revealed, or a replacement for the puzzle to
change its state. */

import java.util.*;
import java.io.*;

class Puzzle extends Entity {
    private String verb, failure, success;
    private List<String> need = new ArrayList<String>();

    private List<Thing> contents;

    Puzzle(String name, String description) {
        super(name, description);
        contents = new ArrayList<Thing>();
    }

    // After constructing the puzzle, set up its parameters.
    void action(String verb, String[] items, Thing[] contents,
        String failure, String success)
    {
        this.verb = verb;
        for(String item : items) this.need.add(item);
        this.failure = failure;
        this.success = success;
        for (Thing x: contents) this.contents.add(x);
    }

    // Announce the puzzle when the player finds it
    void arrive(Place here, PrintStream out) {
        out.println(description);
    }

    // Respond to the triggering verb
    Place act(Place here, String verb, PrintStream out) {
        if (! verb.equals(this.verb)) {
            out.println("Do what to the " + name + "?");
            return here;
        }
        for (String x: need){
            if (here.find(x) == null) {
                out.println(failure);
                return here;
            }
        }
        System.out.println(success);
        for (Thing c: contents) {
            out.println(c.description);
            here.put(c);
        }
        return here;
    }
}
