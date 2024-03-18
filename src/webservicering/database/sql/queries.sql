-- A :result value of :n below will return affected rows:
-- :name sql-insert-account :! :m
-- :doc Persist a account on datbase
insert into accounts (id, owner, created_at) 
values (:id, :owner, :created-at)

-- A :result value of :1 below will return affected rows:
-- :name sql-search-account-by-id :? :1
-- :doc Find account from a specific id
select id, owner, created_at from accounts
where id = :id

-- :name sql-update-account-owner :! :1
update accounts
set owner = :owner
where id = :id

-- :name sql-delete-account-by-id :! :1
delete from accounts where id = :id
