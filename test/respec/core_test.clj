(ns respec.core-test
  (:require [clojure.test :refer :all]
            [respec.core :refer :all]
            [clojure.spec.alpha :as s]
            [clojure.spec.test.alpha :as stest]))

(stest/instrument)

(deftest take-test
  (testing "Testing take"
    (is (= '(1) (take 1 [1])))
    (is (= '(1) (take 10 [1])))
    (is (= '() (take 1 [])))))

(deftest take-test
  (testing "Testing drop"
    (is (thrown? Exception (drop 1 1)))
    (is (thrown? Exception (drop odd? [1])))
    (is (= '(2) (drop 1 [1 2])))
    (is (= '() (drop 10 [1])))
    (is (= '() (drop 1 [])))))

(deftest split-at-test
  (testing "Testing split-at"
    (is (thrown? Exception (split-at 1 1)))
    (is (thrown? Exception (split-at odd? [1])))
    (is (= ['(1) '(2 3)]  (split-at 1 [1 2 3])))
    (is (= ['(1 2 3) '()] (split-at 10 [1 2 3])))
    (is (= ['() '(1 2 3)] (split-at -1 [1 2 3])))))

(deftest distinct-test
  (testing "Testing distinct"
    (is (not (s/valid? :respec.core/distinct-spec 1)))
    (is (s/valid? :respec.core/distinct-spec nil))
    (is (ifn? (distinct)))
    (is (= '() (distinct nil)))
    (is (= '() (distinct [])))
    (is (= '(1 2) (distinct [1 2])))))

(deftest count-test
  (testing "Testing count"
    (is (not (s/valid? :respec.core/count-spec 1)))
    (is (not (s/valid? :respec.core/count-spec "1")))
    (is (s/valid? :respec.core/count-spec nil))
    (is (= 0 (count nil)))
    (is (= 2 (count [1 2])))))

(deftest filter-test
  (testing "Testing filter"
    (is (not (s/valid? :respec.core/filter-spec [1 1])))
    (is (not (s/valid? :respec.core/filter-spec [odd? 1])))
    (is (s/valid? :respec.core/filter-spec [odd? [1]]))
    (is (ifn? (filter odd?)))))

(deftest filterv-test
  (testing "Testing filterv"
    (is (not (s/valid? :respec.core/filter-spec [1 1])))
    (is (not (s/valid? :respec.core/filter-spec [odd? 1])))
    (is (s/valid? :respec.core/filter-spec [odd? [1]])))
    (is (= [1] (filterv odd? [1]))))

(deftest map-test
  (testing "Testing map"
    (is (not (s/valid? :respec.core/map-spec [1 1])))
    (is (not (s/valid? :respec.core/map-spec [odd? 1])))
    (is (= '([1]) (map vector [1])))
    (is (= '([1 1]) (map vector [1] [1])))
    (is (ifn? (map vector)))))

(deftest mapv-test
  (testing "Testing map"
    (is (not (s/valid? :respec.core/map-spec [1 1])))
    (is (not (s/valid? :respec.core/map-spec [odd? 1])))
    (is (= [[1]] (map vector [1])))
    (is (= [[1 1]] (map vector [1] [1])))))
