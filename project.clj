(defproject respec "0.1.0-SNAPSHOT"
  :description "A collection of specs for clojure.core"
  :url "http://github.com/tirkarthi/respec"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0-RC1"]
                 [org.clojure/test.check "0.9.0"]
                 [org.clojure/spec.alpha "0.1.143"]]
  :target-path "target/%s"
  :jvm-opts ^replace [])
