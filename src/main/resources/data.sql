INSERT INTO regions (id, region_name, created_at, updated_at)
VALUES (1, '서울', NOW(), NOW()),
       (2, '부산', NOW(), NOW()),
       (3, '인천', NOW(), NOW());


INSERT INTO stores (id, name, address, score, region_id, created_at, updated_at)
VALUES
    (1, 'Store 1', '서울시 서대문구 이화여대길 52', 4.5, 1, NOW(), NOW()),
    (2, 'Store 2', '서울시 마포구 연남동', 3.8, 1, NOW(), NOW()),
    (3, 'Store 3', '서울시 동작구 흑석동', 2.2, 1, NOW(), NOW()),
    (4, '요아정', '서울시 용산구 이태원동', 4.0, 1, NOW(), NOW()),
    (5, '요아정', '서울시 서대문구 이화여대길 52', 3.2, 1, NOW(), NOW()),
    (6, '요아정', '서울시 강남구 대치동', 4.5, 1, NOW(), NOW());


INSERT INTO missions (id, mission_description, store_id, points_awarded, created_at, updated_at)
VALUES
    (1, 'Store 1-미션 1', 1, NULL, NOW(), NOW()),
    (2, 'Store 1-미션 2', 1, NULL, NOW(), NOW()),
    (3, 'Store 2-미션 1', 2, NULL, NOW(), NOW()),
    (4, 'Store 3-미션 1', 3, NULL, NOW(), NOW());


INSERT INTO reviews (id, description, rating, store_id, user_id, photo_url, created_at, updated_at)
VALUES
    (1111, '너무 좋아요!', 5.0, 1, NULL, 'https://example.com/default_image1.jpg', NOW(), NOW()),
    (1121, '분위기 짱~', 3.0, 1, NULL, 'https://example.com/default_image2.jpg', NOW(), NOW()),
    (1131, '서비스가 좋습니다', 4.8, 2, NULL, 'https://example.com/default_image3.jpg', NOW(), NOW()),
    (1141, '음식이 맛있고 사장님이 친절해요', 4.5, 3, NULL, 'https://example.com/default_image4.jpg', NOW(), NOW());

INSERT INTO user_preferences (id, favorite_food, created_at, updated_at)
VALUES
    (1111, '중식', NOW(), NOW()),
    (1112, '양식', NOW(), NOW()),
    (1113, '치킨', NOW(), NOW()),
    (1114, '분식', NOW(), NOW()),
    (1115, '고기/구이', NOW(), NOW()),
    (1116, '도시락', NOW(), NOW()),
    (1117, '야식', NOW(), NOW()),
    (1118, '패스트푸드', NOW(), NOW()),
    (1119, '디저트', NOW(), NOW()),
    (1120, '아시안푸드', NOW(), NOW());

