package com.svanberggroup.pfago.Utils.Rib.Constants;

public final class RibWebJSInjection {

    public final static String SHOW_TRANSPORT = "javascript:(function(){ document.getElementById('flik9').style.display='block';})();";
    public final static String REMOVE_SIDE_MENU = "javascript:(function(){document.getElementById('viewport').style.left='0px';})();";
    public final static String REMOVE_RIB_LINK = "javascript:(function(){" +
            "    var elems = document.querySelectorAll('.long.regellank');" +
            "    var index = 0, length = elems.length;" +
            "    for ( ; index < length; index++) {" +
            "        elems[index].style.display='none'}" +
            "})();";
    public final static String REMOVE_COLUMNS = "javascript:(function(){" +
            "    var elems = document.querySelectorAll('.kolumn');" +
            "    var index = 0, length = elems.length;" +
            "    for ( ; index < length; index++) {" +
            "        elems[index].style.cssFloat='none';}" +
            "})();";

    public final static String ALIGN_VALUES = "javascript:(function(){" +
            "    var elems = document.querySelectorAll('p');" +
            "    var index = 0, length = elems.length;" +
            "    for ( ; index < length; index++) {" +
            "        elems[index].style.marginLeft='50px';}" +
            "})();";

    private RibWebJSInjection() {
    }
}

