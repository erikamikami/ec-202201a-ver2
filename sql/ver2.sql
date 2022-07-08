--ユーザーテーブル
drop table if exists users cascade;

CREATE TABLE users(
  id serial PRIMARY KEY
  ,last_name varchar(20)
  ,first_name varchar(20)
  ,user_name VARCHAR(10) NOT NULL
  ,email VARCHAR(100) NOT NULL
  ,password TEXT NOT NULL
  ,zipcode INTEGER
  ,prefecture_town VARCHAR(30)
  ,street_address VARCHAR(100)
  ,building VARCHAR(100)
  ,telephone INTEGER
  ,creditcard INTEGER
);

--飲み物商品テーブル
drop table if exists beverrage_items cascade;s

CREATE TABLE beverrage_items(
  id serial PRIMARY KEY
  ,name VARCHAR(100) NOT NULL
  ,description text not null
  ,price_s INTEGER not NULL
  ,price_m INTEGER not NULL
  ,price_l INTEGER not NULL
  ,image bytea not NULL
  ,deleted_flg BOOLEAN not null DEFAULT FALSE
  ,recommend_flg BOOLEAN not null DEFAULT FALSE
  ,season_flg  BOOLEAN not null DEFAULT FALSE
  ,beverrage_items_category_id INTEGER not NULL
);


insert into beverrage_items values(1, 'エスプレッソフラペチーノ', 'ひと口目に感じるエスプレッソは「リストレット」という方法で抽出した力強い香りと優しい苦味を、ふた口目は全体を混ぜて、こだわりのクリームから来るアフォガートのような味わいをお楽しみください。リフレッシュしたい時や、ほっとひと息つきたい時にも、何度でも飲みたくなるフラペチーノ®です。',
 530, 560, 590, pg_read_binary_file('C:\springworkspace\ec-202201a-ver2\src\main\resources\static\img_coffee\2.jpg'), FALSE, FALSE, FALSE, 3);

insert into beverrage_items values(5, 'カフェモカ', 'エスプレッソにほろ苦いチョコレートシロップとミルクを加え、ホットビバレッジにはホイップクリームをトッピング。ちょっとした贅沢を楽しみたい方におすすめです。',
 400, 520, 600, pg_read_binary_file('C:\springworkspace\ec-202201a-ver2\src\main\resources\static\img_coffee\5.jpg'), FALSE, FALSE, FALSE, 1);

insert into beverrage_items values(6, 'カフェラテ', '最も人気のあるエスプレッソ ビバレッジ。リッチなエスプレッソにスチームミルクを注ぎ、フォームミルクを丁寧にトッピングしました。ミルキーな味わいで気持ちを温かくしてくれます。',
 340, 460, 500, pg_read_binary_file('C:\springworkspace\ec-202201a-ver2\src\main\resources\static\img_coffee\6.jpg'), FALSE, FALSE, FALSE, 1);

insert into beverrage_items values(7, 'カプチーノ', 'リッチなエスプレッソに一気にミルクを注ぐことで、一口飲んだときからコーヒー感が感じられるビバレッジです。ベルベットのようにきめ細かいフォームミルクをお楽しみください。',
 340, 460, 500, pg_read_binary_file('C:\springworkspace\ec-202201a-ver2\src\main\resources\static\img_coffee\7.jpg'), FALSE, FALSE, FALSE, 1);

insert into beverrage_items values(8, 'キャラメルマキアート', 'バニラシロップとスチームミルクのコンビネーションになめらかなフォームミルクをたっぷりのせ、その上からエスプレッソを注いでアクセントを付けました。仕上げにオリジナルキャラメルソースをトッピングしています。',
 390, 510, 600, pg_read_binary_file('C:\springworkspace\ec-202201a-ver2\src\main\resources\static\img_coffee\8.jpg'), FALSE, FALSE, FALSE, 1);

insert into beverrage_items values(9, 'キャラメルフラペチーノ', 'コーヒー、ミルク、キャラメルシロップを氷とブレンドした、多くのお客様に愛されているフローズン ビバレッジです。トッピングしたホイップクリームとキャラメルソースと混ぜながら、豊かでほんのり香ばしいキャラメルの風味をお楽しみください。
', 490, 570, 600, pg_read_binary_file('C:\springworkspace\ec-202201a-ver2\src\main\resources\static\img_coffee\9.jpg'), FALSE, FALSE, FALSE, 3);

insert into beverrage_items values(10, 'バニラ クリーム フラペチーノ', 'ミルクとバニラシロップを氷とブレンドし、ホイップクリームをトッピングした、クリーミーな味わいのフローズン ビバレッジ。真っ白な見た目も爽やかです。ミルクとバニラシロップというシンプルな組み合わせはいろいろなカスタマイズとも好相性。',
 490, 570, 600, pg_read_binary_file('C:\springworkspace\ec-202201a-ver2\src\main\resources\static\img_coffee\10.jpg'), FALSE, FALSE, FALSE, 3);

insert into beverrage_items values(11, 'ダークモカフラペチーノ', 'コーヒー、ミルク、ダークチョコレートパウダー、そして人気のチョコレートチップを氷とブレンドした、チョコレートラバーズに人気のフローズンビバレッジ。コーヒーとダークチョコレートのほろ苦い味わいと、チョコレートチップの食感が織り成すハーモニーは、ブラックコーヒーファンにも支持されています。',
 490, 570, 600, pg_read_binary_file('C:\springworkspace\ec-202201a-ver2\src\main\resources\static\img_coffee\11.jpg'), FALSE, FALSE, FALSE, 3);

insert into beverrage_items values(12, '抹茶クリームフラペチーノ', '世界中で様々な形で飲用されている抹茶ですが、スターバックスではミルクと甘みを加えて氷でブレンドしたリフレッシングなフラペチーノ®に仕上げました。',
 490, 570, 600, pg_read_binary_file('C:\springworkspace\ec-202201a-ver2\src\main\resources\static\img_coffee\12.jpg'), FALSE, FALSE, FALSE, 3);

insert into beverrage_items values(13, 'ドリップコーヒー', '世界中のコーヒー産地から厳選された高品質のアラビカ種コーヒー豆を使用したスターバックスの定番商品です。バラエティあふれるコーヒー豆を通して、スターバックスのコーヒージャーニーをお楽しみください。異なるローストレベルのコーヒーを日替わりでご用意していますので、お気に入りの1杯を見つけてみませんか。',
 290, 410, 500, pg_read_binary_file('C:\springworkspace\ec-202201a-ver2\src\main\resources\static\img_coffee\13.jpg'), FALSE, FALSE, FALSE, 1);

insert into beverrage_items values(14, 'アイスコーヒー', '熱を加えずに14時間かけてゆっくりと水で抽出したコールドブリュー コーヒー。香り高い風味が引き出されるよう、特別にブレンド、ローストしたコーヒー豆を使用しています。豊かな味わいとなめらかな口あたりをお楽しみください。',
 330, 450, 500, pg_read_binary_file('C:\springworkspace\ec-202201a-ver2\src\main\resources\static\img_coffee\14.jpg'), FALSE, FALSE, FALSE, 1);

insert into beverrage_items values(15, 'アメリカン', 'エスプレッソに熱いお湯を注いだ、すっきりとしたのどごしのコーヒーです。ドリップ コーヒーのお好きな方にもおすすめです。',
 310, 430, 500, pg_read_binary_file('C:\springworkspace\ec-202201a-ver2\src\main\resources\static\img_coffee\15.jpg'), FALSE, FALSE, FALSE, 1);

insert into beverrage_items values(16, 'エスプレッソ', 'キャラメルのような甘く力強い味とナッツを感じさせる後味。スターバックスのすべてのエスプレッソ ビバレッジに使われているエスプレッソです。どうぞ、お早めにお召し上がりください。',
 310, 350, 500, pg_read_binary_file('C:\springworkspace\ec-202201a-ver2\src\main\resources\static\img_coffee\14.jpg'), FALSE, FALSE, FALSE, 1);

insert into beverrage_items values(17, 'ナッティホワイトモカ', 'ホワイトチョコレートとヘーゼルナッツに香り高いエスプレッソを加えた風味豊かなホワイト モカ。ホイップクリームをツリーに見立て、ナッツ&ホワイトチョコレートソースのリボンと、3色のチョコレート、シルバーのアラザンをイルミネーションのようにちりばめました。ホリデーシーズンにぴったりのあたたかな一杯で、特別なひと時をお楽しみください。',
 450, 570, 600, pg_read_binary_file('C:\springworkspace\ec-202201a-ver2\src\main\resources\static\img_coffee\17.jpg'), FALSE, FALSE, FALSE, 1);

insert into beverrage_items values(18, 'ジンジャーブレッドラテ', 'スターバックスのホリデーといえばやっぱりジンジャーブレッド ラテ、という人も多いのではないでしょうか。ジンジャーブレッドクッキーをイメージした、ほんのり甘くてスパイシーな風味は、この時期にしか味わえない特別なビバレッジです。体の中からじんわりとあたためてくれる一杯で、ほっとリラックスしたひと時をお過ごしください。',
 450, 570, 690, pg_read_binary_file('C:\springworkspace\ec-202201a-ver2\src\main\resources\static\img_coffee\18.jpg'), FALSE, FALSE, FALSE, 1);


--食べ物商品テーブル
drop table if exists food_items cascade;

CREATE TABLE food_items(
  id serial PRIMARY KEY
  ,name VARCHAR(100) NOT NULL
  ,description text not null
  ,price INTEGER not NULL
  ,image bytea not NULL
  ,deleted_flg BOOLEAN not null DEFAULT FALSE
  ,recommend_flg BOOLEAN not null DEFAULT FALSE
  ,season_flg  BOOLEAN not null DEFAULT FALSE
  ,food_items_category_id INTEGER not NULL
);

insert into food_items values(1, 'Gorgeous4サンド', '人気の定番具材「ハム」と「チキン」をセットにした食べごたえ抜群のサンドイッチです。', 
480, pg_read_binary_file('C:\springworkspace\ec-202201a-ver2\src\main\resources\static\img_coffee\1.jpg'), FALSE, FALSE, FALSE, 1);

insert into food_items values(2, 'チョコクッキー', 'ソフトな食感のクッキー生地には、小麦の香ばしさが感じられるよう全粒粉を入れ、砂糖の一部にはブラウンシュガーを使い、コクのある甘さをプラスしています。風味豊かなスターバックスオリジナルのチョコレートチャンクがごろごろ入っていて、どこを食べてもチョコレートの味わいを存分に楽しめます。ショートサイズのマグカップの上に乗せられるくらいのサイズは、コーヒーと一緒に楽しむのにもぴったりです。',
 190, pg_read_binary_file('C:\springworkspace\ec-202201a-ver2\src\main\resources\static\img_coffee\4.jpg'), FALSE, FALSE, FALSE, 2);

insert into food_items values(3, 'Specialキャラメルドーナッツ', 'ドーナツ生地の中に、なめらかで風味豊かなキャラメルフィリングを入れ、仕上げにキャラメルのビター感と香ばしさが楽しめるキャラメルコーティングをかけました。',
 250, pg_read_binary_file('C:\springworkspace\ec-202201a-ver2\src\main\resources\static\img_coffee\3.jpg'), FALSE, FALSE, FALSE, 2);

--飲み物カテゴリ
drop table if exists beverrage_items_category cascade;

CREATE TABLE beverrage_items_category(
  id serial primary key
  ,beverrage_items_category VARCHAR(20) not NULL
);

insert into beverrage_items_category values(1, 'コーヒー');
insert into beverrage_items_category values(2, '紅茶');
insert into beverrage_items_category values(3, 'ソフトドリンク');

--フードカテゴリ
drop table if exists food_category cascade;

CREATE TABLE food_category(
  id serial primary key
  ,food_category VARCHAR(20) not NULL
);

insert into food_category values(1, 'フード');
insert into food_category values(2, 'デザート');


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

--飲み物温度テーブル
--drop table if exists beverage_temp_category;

--CREATE TABLE beverage_temp_category(
--  id serial primary key
--  ,beverage_temp_category VARCHAR(20) NOT NULL
--);

--insert into beverage_temp_category values(1, 'HOT');
--insert into beverage_temp_category values(2, 'COLD');
--insert into beverage_temp_category values(3, '--');


--飲み物サイズテーブル
--drop table if exists beverage_size_category;

--CREATE TABLE beverage_size_category(
--  id serial primary key
--  ,beverage_size_category VARCHAR(20) NOT NULL
--);

--insert into beverage_size_category values(1, 'S');
--insert into beverage_size_category values(2, 'M');
--insert into beverage_size_category values(3, 'L');
--insert into beverage_size_category values(4, 'サイズなし');


--飲み物トッピングテーブル
drop table if exists beverage_topping;

CREATE TABLE beverage_topping(
  id serial primary key
  ,name VARCHAR(100) NOT NULL
  ,price INTEGER not NULL
  ,deleted_flg  BOOLEAN not null DEFAULT FALSE
);

insert into beverage_topping values(1, 'チョコレートソース', 100, FALSE);
insert into beverage_topping values(2, 'キャラメルソース', 100, FALSE);
insert into beverage_topping values(3, 'ホイップクリーム', 100, FALSE);
insert into beverage_topping values(4, '抹茶クリーム', 100, FALSE);
insert into beverage_topping values(5, 'フォームミルク', 50, FALSE);
insert into beverage_topping values(6, 'スチームミルク', 50, FALSE);
insert into beverage_topping values(7, 'アーモンドミルク', 100, FALSE);
insert into beverage_topping values(8, '無脂肪乳', 100, FALSE);
insert into beverage_topping values(9, '豆乳', 100, FALSE);
insert into beverage_topping values(10, 'チョコレートチップ', 100, FALSE);
insert into beverage_topping values(11, 'はちみつ', 30, FALSE);


--注文ステータステーブル
drop table if exists order_status;

CREATE TABLE order_status(
  id serial primary key
  ,order_status VARCHAR(50) NOT NULL
);

insert into order_status values(1, '注文確認中');
insert into order_status values(2, 'オーダー作成中');
insert into order_status values(3, '配送中');
insert into order_status values(4, '配送完了');

--支払方法テーブル
drop table if exists payment_method;

CREATE TABLE payment_method(
  id serial primary key
  ,payment_method VARCHAR(50) NOT NULL
);

insert into payment_method values(1, 'クレジットカード');
insert into payment_method values(2, 'PayPay');