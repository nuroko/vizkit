package nuroko.vizkit.demo;

import mikera.cljutils.Clojure;

public class DemoApp {
	
	public static void main (String[] args) {
		Clojure.require("nuroko.vizkit.demo.app");
		Clojure.eval("(nuroko.vizkit.demo.app/launch)");
	}
}
