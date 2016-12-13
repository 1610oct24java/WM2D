  SELECT DISTINCT COUNT (u.ITEM_ID) AS ITEM_COUNT, r.RECIPE_ID
    FROM USER_ITEM_TABLE u
         INNER JOIN RECIPE_ITEM_TABLE r ON r.ITEM_ID = u.ITEM_ID
   WHERE u.USER_ID = '301' AND u.MEASURE_AMOUNT > 0 AND u.ITEM_STATUS = 1
GROUP BY r.RECIPE_ID;