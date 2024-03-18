(ns webservicering.usecase.delete-account
  (:require [schema.core :as s])
  (:import [java.util UUID]))

(s/defn delete-account-by-id [account-id :- UUID find-account delete-account!]
  (let [account (find-account {:id account-id})]
    (if (nil? account)
      false
      (do
        (delete-account! account)
        true))))