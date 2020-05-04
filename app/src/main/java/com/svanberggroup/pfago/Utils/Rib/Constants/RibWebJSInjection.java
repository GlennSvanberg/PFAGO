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
    public final static String REMOVE_HELP_LINK = "javascript:(function(){" +
            "    var elems = document.querySelectorAll('#helplink');" +
            "    var index = 0, length = elems.length;" +
            "    for ( ; index < length; index++) {" +
            "        elems[index].style.display='none';}" +
            "})();";

    public final static String ALIGN_VALUES = "javascript:(function(){" +
            "    var elems = document.querySelectorAll('#viewport');" +
            "    var index = 0, length = elems.length;" +
            "    for ( ; index < length; index++) {" +
            "        elems[index].style.paddingLeft='10px';}" +
            "})();";
    public final static String PADDING_BOTTOM_TRANSPORT= "javascript:(function(){" +
            "    var elems = document.querySelectorAll('#breadcrumb');" +
            "    var index = 0, length = elems.length;" +
            "    for ( ; index < length; index++) {" +
            "        elems[index].style.display='none';}" +
            "})();";
    public final static String PADDING_BOTTOM_IDENTITET = "javascript:(function(){" +
            "    var elems = document.querySelectorAll('#sitefoot');" +
            "    var index = 0, length = elems.length;" +
            "    for ( ; index < length; index++) {" +
            "        elems[index].style.display='none';}" +
            "})();";

    private RibWebJSInjection() {
    }
}

