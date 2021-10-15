package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import static java.lang.Math.*;
import static java.lang.System.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(Arrays.deepToString(millionsRounding(new String[] {"Manila", "13923452"},new String[] {"Jakarta", "10770487"})));
        System.out.println(Arrays.toString(otherSides(2)));
        System.out.println(rps("rock","paper"));
        System.out.println(warOfNumbers(2,8,7,5));
        System.out.println(reverseCase("Happy Birthday"));
        System.out.println(inatorInator("Shrink"));
        System.out.println(doesBrickFit(1,1,1,1,1));
        System.out.println(totalDistance(70.0,7.0,0, false));
        System.out.println(mean(new int[] {1, 0, 4, 5, 2, 4, 1, 2, 3, 3, 3}));
        System.out.println(parityAnalysis(243));
    }


    //1.Учитывая массив городов и населения, верните массив, в котором все население
    //округлено до ближайшего миллиона.

    public static String[][] millionsRounding(String[]... a) {
        for (int i = 0; i < a.length; i++) {
            BigDecimal r = new BigDecimal(a[i][1]);
            //setScale - задает кол-во символов после запятой, RoundingMode - округение(в большую)
            r = r.divide(new BigDecimal("1000000")).setScale(0, RoundingMode.HALF_UP);
            a[i][1] = r.toString() + "000000";
        }
        return a;
    }


    //2.Учитывая самую короткую сторону треугольника 30° на 60° на 90°, вы должны
    //найти другие 2 стороны (верните самую длинную сторону, сторону средней
    //длины).
    // Примечание:
    //- треугольники 30° на 60° на 90° всегда следуют этому правилу, скажем, самая короткая
    //длина стороны равна x единицам, гипотенуза будет равна 2 единицам, а другая сторона
    //будет равна x * root3 единицам.
    //- Результаты тестов округляются до 2 знаков после запятой.
    //- Верните результат в виде массива.

    public static double[] otherSides(double s)
    {
        double[] str=new double[2];
        str[0]= 2*s;//нахождение гипотенузы
        str[1]=s*sqrt(3);//находжение второго катета
        //округление до двух знаков после запятой
        str[0]=ceil(str[0]*100)/100;
        str[1]=ceil(str[1]*100)/100;
        return str;
    }



    //3. Создайте функцию, имитирующую игру "камень, ножницы, бумага". Функция
    //принимает входные данные обоих игроков (камень, ножницы или бумага), первый
    //параметр от первого игрока, второй от второго игрока. Функция возвращает
    //результат как таковой:
    //"Игрок 1 выигрывает"
    //"Игрок 2 выигрывает"
    //"НИЧЬЯ" (если оба входа одинаковы)
    //Правила игры камень, ножницы, бумага, если не известны:
    //Оба игрока должны сказать одновременно "камень", "бумага" или "ножницы".
    //Камень бьет ножницы, бумага бьет камень, ножницы бьют бумагу.

    public static String rps (String first, String second) {
        if (first == second) return "TIE";
        if ((first == "rock" && second == "scissors") || (first == "paper" && second == "rock") || (first == "scissors" && second == "paper"))
            return "Player 1 wins";
        else return "Player 2 wins";
    }

    //4.Идет великая война между четными и нечетными числами. Многие уже погибли в
    //этой войне, и ваша задача-положить этому конец. Вы должны определить, какая
    //группа суммируется больше: четная или нечетная. Выигрывает большая группа.
    // Создайте функцию, которая берет массив целых чисел, суммирует четные и нечетные
    //числа отдельно, а затем возвращает разницу между суммой четных и нечетных чисел.

    public static int warOfNumbers(int... numbers)
    {
        int even=0;//четные
        int odd=0;//нечетные
        for (int num : numbers)
        {
            if(num%2==0)
            {
                even=even+num;
            }
            else
            {
                odd=odd+num;
            }
        }
        return abs(even-odd);
    }

    //5.Учитывая строку, создайте функцию для обратного обращения. Все буквы в
    //нижнем регистре должны быть прописными, и наоборот.

    public static String reverseCase (String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i <chars.length; i ++) {
            // isUpper/toLowerCase определяют в каком регистре находиться переменная
            if (Character.isUpperCase(chars[i])) chars[i] = Character.toLowerCase(chars[i]);
            else chars[i] = Character.toUpperCase(chars[i]);
        }
        String result = new String (chars);
        return result;
    }
    //6. Создайте функцию, которая принимает строку из одного слова и выполняет
    //следующие действия:
    //Конкатенирует inator до конца, если слово заканчивается согласным, в противном
    //случае вместо него конкатенирует -inator
    //Добавляет длину слова исходного слова в конец, снабженный '000'.

    public static String inatorInator (String s) {
        char [] gl = {'a','e','i','o', 'u', 'y'};
        boolean last = false;
        for (char c:gl) {
            if (c == s.toCharArray()[s.length()-1]) {
                last = true;
            }
        }
        if (last)
            return s + "-inator " + s.length() +"000";
        else
            return s + "inator  " + s.length() + "000";
    }

    //7. Напишите функцию, которая принимает три измерения кирпича: высоту(a),
    //ширину(b) и глубину(c) и возвращает true, если этот кирпич может поместиться в
    //отверстие с шириной(w) и высотой(h).

    public static boolean doesBrickFit (int a, int b, int c, int w, int h) {
        return (w-a>=0 && h - b >=0)||(w-b>=0 && h-a>=0)||(w-c>=0 &&  h-a>=0)||(w-a>=0 && h-c>=0)||(w-b>=0 && w-c>=0)||(w-c>=0 && w-b >=0);
    }


    //8. Напишите функцию, которая принимает топливо (литры), расход топлива
    //(литры/100 км), пассажиров, кондиционер (логическое значение) и возвращает
    //максимальное расстояние, которое может проехать автомобиль.
    //топливо-это количество литров топлива в топливном баке.
    //Расход топлива-это базовый расход топлива на 100 км (только с водителем внутри).
    //Каждый дополнительный пассажир увеличивает базовый расход топлива на 5%.
    //Если кондиционер включен, то его общий (не базовый) расход топлива увеличивается на 10%

    public static double totalDistance(double lit, double ras, int pas, boolean bool) {
        if (pas > 1) {
            for (int i = 1; i <pas; i ++) {
                ras = ras * 1.05;
            }
        }
        if (bool) {
            ras *= 1.1;
        }
        return (double) lit / ras*100;
    }

    //9. Создайте функцию, которая принимает массив чисел и возвращает среднее
    //значение (average) всех этих чисел.

    public static double mean(int[] a) {
        int sum = 0;
        for (int i : a) {
            sum = sum + i;
        }
        return ceil((((double) sum / a.length)) * 100) / 100; //ceil - округление в большую сторону
    }

    //10. Создайте функцию, которая принимает число в качестве входных данных и
    //возвращает true, если сумма его цифр имеет ту же четность, что и все число. В
    //противном случае верните false.

// Вычисляем сумму цифр, сравниваем результаты остатка от деления на 2
    public static boolean parityAnalysis(int a) {
        int sum = 0;
        int n = a;
        while(n != 0){
            sum += (n % 10);
            n/=10;
        }
        return ((a % 2 == 0 ) && (sum % 2 == 0))||((a % 2 != 0) && (sum % 2 != 0));
    }
}
