(ns respec.core
  (:require [clojure.spec.alpha :as s]
            [clojure.spec.test.alpha :as stest]))

(s/fdef clojure.core/dec
        :args (s/cat :x number?)
        :ret number?)

(s/fdef clojure.core/inc
        :args (s/cat :x number?)
        :ret number?)

(s/fdef clojure.core/rand-int
        :args (s/cat :x number?)
        :ret number?)

(s/fdef clojure.core/first
        :args coll?
        :ret any?)

(s/fdef clojure.core/rand-nth
        :args coll?
        :ret any?)

(s/fdef clojure.core/rest
        :args coll?
        :ret coll?)

(s/fdef clojure.core/frequencies
        :args coll?
        :ret map?)

(s/def ::filter-spec (s/cat :fn ifn? :coll (s/? coll?)))

(s/fdef clojure.core/filter
        :args ::filter-spec
        :ret coll?)

(s/fdef clojure.core/filterv
        :args ::filter-spec
        :ret vector?)

(s/def ::keep-spec (s/cat :fn ifn? :coll (s/? coll?)))

(s/fdef clojure.core/keep
        :args ::keep-spec
        :ret coll?)

(s/fdef clojure.core/keep-indexed
        :args ::keep-spec
        :ret coll?)

(s/def ::map-spec (s/cat :fn ifn? :coll (s/* coll?)))

(s/fdef clojure.core/map
        :args ::map-spec
        :ret coll?)

(s/fdef clojure.core/mapcat
        :args ::map-spec
        :ret coll?)

(s/fdef clojure.core/mapv
        :args ::map-spec
        :ret vector?)

(s/def ::every-spec (s/cat :fn ifn? :coll coll?))

(s/fdef clojure.core/every
        :args ::every-spec
        :ret coll?)

(s/def ::group-by-spec (s/cat :fn ifn? :coll coll?))

(s/fdef clojure.core/group-by
        :args ::group-by-spec
        :ret coll?)

(s/def ::drop-spec (s/cat :number integer? :coll (s/? coll?)))

(s/fdef clojure.core/drop
        :args ::drop-spec
        :ret coll?)

(s/def ::take-spec (s/cat :number integer? :coll (s/? coll?)))

(s/fdef clojure.core/take
        :args ::take-spec
        :ret coll?)

(s/fdef clojure.core/take-nth
        :args (s/cat :number integer? :coll (s/? coll?))
        :ret coll?)

(s/fdef clojure.core/take-while
        :args (s/cat :number integer? :coll coll?)
        :ret coll?)

(s/fdef clojure.core/drop-while
        :args (s/cat :number integer? :coll coll?)
        :ret coll?)

(s/fdef clojure.core/split-at
        :args (s/cat :number integer? :coll coll?)
        :ret coll?)

(s/fdef clojure.core/split-with
        :args (s/cat :pred ifn? :coll coll?)
        :ret coll?)

(s/fdef clojure.core/merge
        :args (s/spec (s/* (s/nilable map?)))
        :ret (s/nilable map?))

(s/fdef clojure.core/nthnext
        :args (s/cat :coll coll? :n #(and (integer? %1)
                                          (or nat-int? %1)))
        :ret coll?)

(s/fdef clojure.core/nthrest
        :args (s/cat :coll coll? :n #(and (integer? %1)
                                          (or nat-int? %1)))
        :ret coll?)

(s/fdef clojure.core/take-last
        :args (s/cat :number integer? :coll coll?)
        :ret coll?)

(s/def ::distinct-spec (s/nilable coll?))

(s/fdef clojure.core/distinct
        :args ::distinct-spec
        :ret coll?)

(s/def ::count-spec (s/nilable coll?))

(s/fdef clojure.core/count
        :args ::count-spec
        :ret integer?)

(s/fdef clojure.core/even?
        :args #(integer? (first %1))
        :ret boolean?)

(s/fdef clojure.core/odd?
        :args #(integer? (first %1))
        :ret boolean?)

(s/fdef clojure.core/zero?
        :args (s/cat :x number?)
        :ret boolean?)

(s/fdef clojure.core/cycle
        :args (s/cat :coll coll?)
        :ret coll?)

(s/fdef clojure.core/empty
        :args (s/cat :coll coll?)
        :ret coll?)

(s/fdef clojure.core/vals
        :args (s/nilable coll?)
        :ret coll?)

(s/fdef clojure.core/keys
        :args (s/nilable coll?)
        :ret coll?)

(s/fdef clojure.core/zipmap
        :args (s/cat :keys coll? :vals coll?)
        :ret map?)

(s/fdef clojure.core/reverse
        :args coll?
        :ret coll?)

(s/fdef clojure.core/max
        :args (s/+ number?)
        :ret number?)

(s/fdef clojure.core/min
        :args (s/+ number?)
        :ret number?)

(s/fdef clojure.core/pos?
        :args (s/cat :x number?)
        :ret boolean?)

(s/fdef clojure.core/neg?
        :args (s/cat :x number?)
        :ret boolean?)

(s/fdef clojure.core/quot
        :args (s/cat :num number? :div (and number? (not zero?)))
        :ret number?)

(s/fdef clojure.core/rem
        :args (s/cat :num number? :div (and number? (not zero?)))
        :ret number?)

(s/fdef clojure.core/peek
        :args coll?
        :ret any?)

(s/fdef clojure.core/pop
        :args coll?
        :ret any?)

(s/fdef clojure.core/concat
        :args (s/* coll?)
        :ret coll?)

(s/fdef clojure.core/select-keys
        :args (s/cat :map map? :keys coll?)
        :ret map?)

(s/fdef clojure.core/contains?
        :args (s/cat :coll coll? :key any?)
        :ret boolean?)

(s/fdef clojure.core/comp
        :args (s/* ifn?)
        :ret ifn?)

(s/fdef clojure.core/juxt
        :args (s/+ ifn?)
        :ret ifn?)
