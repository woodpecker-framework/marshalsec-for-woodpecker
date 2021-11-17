package me.gv7.woodpecker.marshalsec.gadgets;

import me.gv7.woodpecker.marshalsec.MarshallerBase;
import me.gv7.woodpecker.marshalsec.UtilFactory;

public interface ResourceGadget extends Gadget{
    @Args ( minArgs = 1, args = {
            "codebase"
    }, defaultArgs = {
            MarshallerBase.defaultCodebase
    } )
    Object makeResource (UtilFactory uf, String[] args ) throws Exception;
}
