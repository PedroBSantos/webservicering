(ns webservicering.usecase.create-account
  (:require [webservicering.domain.model :refer [new-account]]
            [schema.core :as s]))

(def CreateAccountInput
  {:owner String})

(s/defn ^:always-validate create-account [input :- CreateAccountInput save-account!]
  (let [owner (:owner input)
        account (new-account owner)]
    (save-account! account)
    {:id (:id account)
     :owner (:owner account)}))