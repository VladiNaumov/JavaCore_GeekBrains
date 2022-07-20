package org.example.more.stringBilder;

public class Main {

        public static void main(String[] args) {

                String s = "Предложение    один  Теперь   предложение   два   Тут предложение           три";
                System.out.println(s);

                //Убираем лишние пробелы

                String s1 = s.replaceAll(" +", " "); //заменяем лишние пробелы на один пробел
                System.out.println(s1);

                //Ставим точку после заглавных букв

                StringBuilder s2 = new StringBuilder(s1);

                for (int i = 1; i < s1.length(); i++) {
                        if (s1.charAt(i) >= 'А' && s1.charAt(i) <= 'Я') //определяем заглавную букву
                                s2.setCharAt(i - 1, '.'); // если заглавная буква определена, возвращаемся на один символ назад i - 1

                }
                s2.insert(s2.length(), ". ");


                System.out.println(s2);


                //Ставим пробел после точек
                StringBuilder s3 = s2;

                for (int i = 0; i < s3.length(); i++) {
                        if (s3.charAt(i) == '.') {
                                s3.insert(++i, ' ');
                        }
                }

                System.out.println(s3);

        }

  }
