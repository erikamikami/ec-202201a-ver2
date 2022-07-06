--ユーザーテーブル
drop table if exists users cascade;

CREATE TABLE users(
  id serial PRIMARY KEY
  ,last_name varchar(20)
  ,first_name varchar(20)
  ,user_name VARCHAR(10) NOT NULL
  ,email VARCHAR(100) NOT NULL
  ,password TEXT NOT NULL
  ,zipcode VARCHAR(7)
  ,prefecture_town VARCHAR(30)
  ,street_address VARCHAR(100)
  ,building VARCHAR(100)
  ,telephone VARCHAR(15)
  ,creditcard VARCHAR(17)
);

--商品テーブル
drop table if exists items cascade;

CREATE TABLE items(
  id serial PRIMARY KEY
  ,name VARCHAR(100) NOT NULL
  ,description text not null
  ,price INTEGER not NULL
  ,image text not NULL
  ,deleted_flg BOOLEAN not null DEFAULT FALSE
  ,recommend_flg BOOLEAN not null DEFAULT FALSE
  ,season_flg  BOOLEAN not null DEFAULT FALSE
  ,items_category_id INTEGER not NULL
  ,beverrage_temp_category_id INTEGER not NULL
  ,beverrage_size_category_id INTEGER not NULL
);


--注文履歴テーブル
drop table if exists order_histories cascade;

CREATE TABLE order_histories(
  order_number text PRIMARY KEY
  ,last_name VARCHAR(20) not NULL
  ,first_name VARCHAR(20) not NULL
  ,email VARCHAR(100) NOT NULL
  ,zipcode VARCHAR(7)
  ,prefecture_town VARCHAR(30)
  ,street_address VARCHAR(100)
  ,building VARCHAR(100)
  ,telephone VARCHAR(15)
  ,total_price INTEGER NOT NULL
  ,order_time TIMESTAMP not NULL
  ,payment_method_id INTEGER NOT NULL
  ,order_status_id INTEGER NOT NULL
);

--注文商品テーブル
drop table if exists order_items cascade;

CREATE TABLE order_items(
  id serial primary key
  ,name VARCHAR(100) not NULL
  ,price INTEGER NOT NULL
  ,quantity INTEGER NOT NULL
  ,beverage_size_category_id INTEGER
  ,beverage_temp_category_id INTEGER
  ,beverage_topping_name VARCHAR(100)
);

--注文商品テーブル
drop table if exists beverage_temp_category;

CREATE TABLE beverage_temp_category(
  id serial primary key
  ,beverage_temp_category VARCHAR(20) NOT NULL
);


--注文商品テーブル
drop table if exists beverage_size_category;

CREATE TABLE beverage_size_category(
  id serial primary key
  ,beverage_size_category VARCHAR(20) NOT NULL
);


--飲み物トッピングテーブル
drop table if exists beverage_topping;

CREATE TABLE beverage_topping(
  id serial primary key
  ,name VARCHAR(100) NOT NULL
  ,price INTEGER not NULL
  ,deleted_flg  BOOLEAN not null DEFAULT FALSE
);


--注文ステータステーブル
drop table if exists order_status;

CREATE TABLE order_status(
  id serial primary key
  ,order_status VARCHAR(50) NOT NULL
);

--支払方法テーブル
drop table if exists payment_method;

CREATE TABLE payment_method(
  id serial primary key
  ,payment_method VARCHAR(50) NOT NULL
);