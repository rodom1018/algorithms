SELECT A.AUTHOR_ID, AUTHOR_NAME, CATEGORY, SUM(SALES * PRICE) TOTAL_SALES
FROM BOOK AS B 
JOIN AUTHOR AS A
ON B.AUTHOR_ID = A.AUTHOR_ID
JOIN BOOK_SALES AS S
ON B.BOOK_ID = S.BOOK_ID
WHERE YEAR(SALES_DATE) = 2022 AND MONTH(SALES_DATE) = 1
GROUP BY A.AUTHOR_NAME, CATEGORY
ORDER BY A.AUTHOR_ID, CATEGORY DESC