(ns webservicering.domain.model 
  (:import [java.time LocalDateTime]
           [java.util UUID]))

(defrecord Account [^UUID id ^String owner ^LocalDateTime created-at])
(defn new-account [owner]
  (let [account-id (str (random-uuid))
        created-at (LocalDateTime/now)]
    (->Account account-id owner created-at)))
