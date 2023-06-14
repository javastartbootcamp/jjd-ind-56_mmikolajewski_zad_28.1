INSERT INTO
    category(name, description)
VALUES
    ('AGD', 'pralki, lodówki, kuchenki mikrofalowe, suszarki do włosów albo czajniki'),
    ('RTV', 'odbiorniki radiowe (radioodbiorniki) i telewizyjne (telewizory)'),
    ('MEBLE', 'meble kuchenne, do pokoju, do łazienki, do szopy, ogrodowe'),
    ('INNE', 'wszystko inne');

INSERT INTO
    offer(title, description, img_url, price, category_id)
VALUES
    ('Telewizor', 'Pioneer Kuro', 'https://www.220-electronics.com/media/catalog/product/cache/06e563bb4bf8bb99ff5c3485d61b5ba4/p/i/pioneer-pdp428xg-multisystem-plasma_1.jpg', 1237, 2),
    ('Telewizor', 'SAMSUNG T5300', 'https://m.media-amazon.com/images/I/71LJJrKbezL._AC_SL1500_.jpg', 5500, 2),
    ('Mebelek', 'Szafeczka koło łóżeczka', 'https://i.pinimg.com/236x/f8/8a/f3/f88af3de1577cebb62976475c3e0aec3--weird-furniture-unique-furniture.jpg', 1237, 3),
    ('Odkurzacz', 'Henry Hoover vacuum cleaner', 'https://www.techadvisor.com/wp-content/uploads/2023/05/henry_vacuum.jpg?quality=50&strip=all', 1200, 1),
    ('Deska', 'Deska dla starego', 'https://i.ebayimg.com/images/g/HxwAAOSwLXtamDZu/s-l1600.jpg', 100, 4);