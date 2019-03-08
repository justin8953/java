/* An NPC in an adventure game.  It has a boolean to indicate whether has talked with
NPC.   */

import java.io.*;
import java.util.*;

class Npc extends Entity {
    private boolean finded;

    Npc(String name, String description)
    {
        super(name, description);
    }

    // Respond to the verbs Talk
    Place act(Place here, String verb, PrintStream out) {
        if (verb.equals("Talk")) Talk(here, out);
        else out.println("You can't " + verb + " NPC.");
        finded = false;
        return here;
    }

    // Talk with the NPC by marking it as being Talked
    private void Talk(Place here, PrintStream out) {
        if (finded) {
            out.println("You are already talked to" + name);
            return;
        }
        out.println(description);
        finded = true;
    }


    // When the player moves, and this object is being carried, move
    // with the player.
    void move(Place here, Place there, PrintStream out) {
        if (! finded) return;
        here.get(name);
        there.put(this);
    }

    // When arriving in a place, announce things which aren't being carried.
    void arrive(Place here, PrintStream out) {
        if (finded) return;
    }
}
