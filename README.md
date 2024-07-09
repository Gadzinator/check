1. Откройте командную строку (терминал).
2. Перейдите в корневую директорию вашего проекта (где лежит папка src).
3. Скомпилируйте ваш класс с помощью команды: 
javac -cp src src/main/java/ru/clevertec/check/CheckRunner.java src/main/java/ru/clevertec/check/CheckRunner.java

4. Пример запуска пронраммы через консоль:
   java -cp src ./src/main/java/ru/clevertec/check/CheckRunner.java 3-1 2-5 5-1 discountCard=1111
   balanceDebitCard=100

Программа выводит квитанцию на экран или сохраняет ее в файл result.csv в текущей директории.
Она может работать с данными о продуктах и скидочными картами, предоставленными в определенном формате


