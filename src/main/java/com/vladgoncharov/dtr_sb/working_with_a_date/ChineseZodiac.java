package com.vladgoncharov.dtr_sb.working_with_a_date;

import lombok.Data;

import java.text.DecimalFormat;

// Класс вычисляет в год кого рожден пользователь
@Data
public class ChineseZodiac {

    private String year;

    private String chineseZodiac;
    private String dateChineseZodiac;
    private String textAboutTheChineseZodiac1;
    private String textAboutTheChineseZodiac2;
    private int imgName;


    public ChineseZodiac() {
    }

    public void getResult() {
        String difference = getTwoNumbersAfterComma();
        chineseZodiac = searchChineseZodiac(difference);
    }

    private String getTwoNumbersAfterComma() {
        double yearDouble = Double.parseDouble(year);
        double result = (yearDouble / 12) - Math.floor(yearDouble / 12);
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        return decimalFormat.format(result);
    }

    //  помощью остатка из 2 цифр после запятой совершаю поиск нужного животного
    private String searchChineseZodiac(String difference) {
        switch (difference) {
            case "0.0":
                return Monkey();
            case "0.08":
                return Rooster();
            case "0.17":
                return Dog();
            case "0.25":
                return Pig();
            case "0.33":
                return Rat();
            case "0.42":
                return Ox();
            case "0.5":
                return Tiger();
            case "0.58":
                return Rabbit();
            case "0.67":
                return Dragon();
            case "0.75":
                return Snake();
            case "0.83":
                return Horse();
            case "0.92":
                return Ram();
            default:
                return "Неизвестная дата";
        }
    }

    private String Monkey() {
        textAboutTheChineseZodiac(1);
        imgName = 1;
        return "Обезьяна";
    }

    private String Rooster() {
        textAboutTheChineseZodiac(2);
        imgName = 2;
        return "Петух";
    }

    private String Dog() {
        textAboutTheChineseZodiac(3);
        imgName = 3;
        return "Собака";
    }

    private String Pig() {
        textAboutTheChineseZodiac(4);
        imgName = 4;
        return "Свинья (Кабан)";
    }

    private String Rat() {
        textAboutTheChineseZodiac(5);
        imgName = 5;
        return "Крыса";
    }

    private String Ox() {
        textAboutTheChineseZodiac(6);
        imgName = 6;
        return "Бык";
    }

    private String Tiger() {
        textAboutTheChineseZodiac(7);
        imgName = 7;
        return "Тигр";
    }

    private String Rabbit() {
        textAboutTheChineseZodiac(8);
        imgName = 8;
        return "Кролик";
    }

    private String Dragon() {
        textAboutTheChineseZodiac(9);
        imgName = 9;
        return "Дракон";
    }

    private String Snake() {
        textAboutTheChineseZodiac(10);
        imgName = 10;
        return "Змея";
    }

    private String Horse() {
        textAboutTheChineseZodiac(11);
        imgName = 11;
        return "Лошадь";
    }

    private String Ram() {
        textAboutTheChineseZodiac(12);
        imgName = 12;
        return "Козы";
    }

    private void textAboutTheChineseZodiac(int number) {
        //Monkey
        if (number == 1) {
            dateChineseZodiac = "1956 1968 1980 1992 2004 2016 2028 2040 2052";
            textAboutTheChineseZodiac1 = "Люди, рождённые в год Обезьяны, притягательны, сообразительны и остроумны. А " +
                    "природная тяга к шалостям, любопытство и находчивость добавляют их характеру озорства." +
                    "Обезьяны любят розыгрыши и подшутить над другими. Им нравится дурачиться, и, хотя они " +
                    "не имеют дурных намерений, их шутки иногда ранят чувства окружающих их людей.";
            textAboutTheChineseZodiac2 = "Обезьяны быстро учатся и умеют находить выгоду при любых обстоятельствах." +
                    " У них много интересов и им нужен такой спутник/ спутница, которые смогут их мотивировать" +
                    " и вдохновлять. В то время как некоторым нравится эксцентричная натура Обезьяны, другие" +
                    " с насторожённостью относятся к их беспокойному, хитрому и любознательному характеру." +
                    "Хотя они умны и изобретательны, Обезьяны не всегда умеют правильно преподнести свои таланты." +
                    " Им нравятся непростые задачи, и обычно Обезьяны предпочитают жить в больших городах.";

        }
        //Rooster
        if (number == 2) {
            dateChineseZodiac = "1945 1957 1969 1981 1993 2005 2017 2029 2041 2053";
            textAboutTheChineseZodiac1 = "Петухи очень наблюдательны. Они трудолюбивые, находчивые, смелые и талантливые," +
                    " Петухи очень уверены в себе. Родившиеся в год Петуха, несомненно, душа компании. Они " +
                    "активные, забавные, популярные в своём окружении. Петух – разговорчивый, общительный, открытый," +
                    " честный и верный своим родным и друзьям. Им нравится быть в центре внимания, они " +
                    "привлекательны и отлично выглядят.";
            textAboutTheChineseZodiac2 = "Петухи очень любят находиться в обществе: и на вечеринке с друзьями, и на рабочей " +
                    "встрече или собрании. Они наслаждаются вниманием толпы, показывая свои привлекательность " +
                    "и очарование при любом удобном случае. Петухи ожидают, что когда они что-то рассказывают, " +
                    "окружающие будут их внимательно слушать, и Петух может выйти из себя, если этого не происходит." +
                    " Тщеславные и хвастливые, Петухи постоянно нахваливают себя и свои достижения." +
                    "Их стремление и желание постоянно находиться в центре внимания может иногда " +
                    "раздражать окружающих.";
        }
        //Dog
        if (number == 3) {
            dateChineseZodiac = "1946 1958 1970 1982 1994 2006 2018 2030 2042 2054";
            textAboutTheChineseZodiac1 = "Люди, родившиеся в год Собаки, - верные и честные, внимательные и добрые, " +
                    "благоразумные и осмотрительные. Они преданны и сделают всё для своих близких." +
                    "Из-за того, что Собаке сложно правильно выражать свои чувства и мысли, она может " +
                    "производить впечатление упрямой личности. Но это лишь оттого, что рождённые под этим " +
                    "знаком стараются сделать мир хоть чуточку лучше.";
            textAboutTheChineseZodiac2 = "Собака благородна и великодушна. Люди, родившиеся в год Собаки, не " +
                    "склонны к преступлениям или корысти. Они ищут размеренную жизнь и крепкую семью, " +
                    "чтобы забыть о несправедливостях и тревогах этого мира." +
                    "Если в них сомневаются, Собаки впадают в пессимизм и думают, что мир сложен и жесток. " +
                    "Они живут в ожидании плохого, не умея радоваться хорошему.";
        }
        //Pig
        if (number == 4) {
            dateChineseZodiac = "1923 1935 1947 1959 1971 1983 1995 2007 2019 2031 2043 2055";
            textAboutTheChineseZodiac1 ="Рождённые в год Свиньи отличаются усердием, состраданием и щедростью. Когда они" +
                    " ставят перед собой цель, то умеют сосредоточиться и направить всю свою энергию на её " +
                    "достижение. И хотя Свинья редко обращается за помощью, тем не менее, родившиеся под этим " +
                    "знаком не откажутся помочь другим. Они никогда не подозревают обмана, поэтому их легко обмануть.";
            textAboutTheChineseZodiac2 = "В трудных ситуациях Свинья остаётся спокойна и не впадает в панику." +
                    " Все зависимости от того, насколько серьёзны проблемы, родившиеся под знаком Свиньи " +
                    "подойдут к их решению взвешенно, со всей осторожностью. Сильно развитое чувство " +
                    "ответственности помогает Свинье доводить начатое дело до конца.";
        }
        //Rat
        if (number == 5) {
            dateChineseZodiac = "1948 1960 1972 1984 1996 2008 2020 2032 2044 2056";
            textAboutTheChineseZodiac1 = "Крысы сообразительны, находчивы и разносторонни. Крысы обладают" +
                    " сильно развитой интуицией и быстрой реакцией, они легко приспосабливаются к новой" +
                    " среде. Богатое воображение и наблюдательность позволяют рождённым в год Крысы выгодно" +
                    " пользоваться возникающими возможностями. Крысы очень любопытны и рады попробовать" +
                    " свои силы в чём угодно, справляясь с этим очень умело.";
            textAboutTheChineseZodiac2 = "Женщины-Крысы милые, умные и обаятельные. Они хорошие хозяйки, " +
                    "сообразительные и способны научиться чему угодно. Из-за недостатка храбрости, а также" +
                    " умения управлять другими, Крысы не становятся хорошими лидерами. Они придирчивы и " +
                    "преследуют свои цели, но не обладают широкими взглядами. Крысы добрые, но иногда бывают " +
                    "невежливы с другими. Люди, родившиеся под знаком Крысы, обычно спят допоздна, ведь " +
                    "грызуны ведут ночной образ жизни.";
        }
        //Ox
        if (number == 6) {
            dateChineseZodiac = "1937 1949 1961 1973 1985 1997 2009 2021 2033 2045 2057";
            textAboutTheChineseZodiac1 = "Быки известны своим усердием, надёжностью, силой и решимостью. Честные по " +
                    "своей природе, Быки – большие патриоты своей страны, они амбициозны и верят в идеалы. " +
                    "Рождённым в год Быка важны традиции, семья и работа. Как видно из этих качеств, Быки – " +
                    "консерваторы. Женщины-Быки – верные жёны, придающие большое значение образованию своих детей.";
            textAboutTheChineseZodiac2 = "Желание двигаться вперёд и большое терпение помогают Быку шаг за шагом " +
                    "добиваться своих целей. Они не зависят от мнения других людей или окружающей обстановки, " +
                    "действуя в соответствии со своими идеалами и возможностями. Прежде чем решиться на что-то, они" +
                    " подготовят чёткий план, описав детально каждый шаг, вложив сильную веру и физическую силу." +
                    " Именно поэтому родившиеся в год Быка добиваются больших успехов." +
                    "К минусам характера Быка можно отнести плохие коммуникативные навыки. У них не получается" +
                    " лёгкого общения с окружающими, они даже часто думаю, что и не стоит обмениваться идеями " +
                    "с другими людьми. Быки упрямы и придерживаются своего собственного пути.";

        }
        //Tiger
        if (number == 7) {
            dateChineseZodiac = "1938 1950 1962 1974 1986 1998 2010 2022 2034 2046 2058";
            textAboutTheChineseZodiac1 = "Рождённые в год Тигра – смелые, непредсказуемые, уверенные в себе. Они очень " +
                    "обаятельны и умеют расположить к себе. Но иногда они могут быть импульсивными,раздражительными " +
                    "и избалованными. Тигры упрямы, решительны и своевольны. Они влиятельны, любят " +
                    "соревноваться и всегда держат свое слово.";
            textAboutTheChineseZodiac2 = "Родившиеся в год Тигра ответственные и отличаются силой духа, а потому" +
                    " среди них встречаются прекрасные лидеры. Они не склонны к долгим приготовлениям, " +
                    "но легко справляются со всем, что встретится на пути.";
        }
        //Rabbit
        if (number == 8) {
            dateChineseZodiac = "1951 1963 1975 1987 1999 2011 2023 2035 2047 2059";
            textAboutTheChineseZodiac1 = "Кролики по характеру спокойные, тихие и чуткие, а также проворные, умелые," +
                    " добрые, терпеливые и очень ответственные. Однако они могут быть легкомысленны и упрямы," +
                    " ранимы и чересчур скрытны. В общем и целом, Кролики отличаются приятным характером и " +
                    "умеют расположить к себе.";
            textAboutTheChineseZodiac2 = "Кролики-мужчины всегда обращаются к людям вежливо, с доброжелательной улыбкой," +
                    " которая позволяет проникнуться доверием и симпатией к представителям этого знака зодиака." +
                    " Когда возникают небольшие проблемы, Кролики справляются с ними аккуратно и методично. " +
                    "Если ситуация более серьёзная, они не унывают и не сдаются, а стараются найти решение." +
                    " Эта черта характера Кроликов помогает им рано или поздно достигнуть завидного успеха." +
                    "Кролики-женщины не только привлекательны и элегантны, но и благожелательны и обладают " +
                    "добрым сердцем. Кролики преданны близким им людям, но не спешат делиться с окружающими " +
                    "своими мыслями и склонны витать в облаках. Рождённые в год Кролика слишком осторожны и " +
                    "консервативны, а потому иногда упускают хорошие возможности.";
        }
        //Dragon
        if (number == 9) {
            dateChineseZodiac = "1928 1940 1952 1964 1976 1988 2000 2012 2024 2036 2048 2060";
            textAboutTheChineseZodiac1 = "Дракон – единственное мифическое животное в китайском зодиаке. Это" +
                    " самый сильный и мощный знак, но он также славится своей горячностью и острым языком. " +
                    "В древние времена считалось, что благодаря властности и амбициозности, Драконы способны" +
                    " держать под контролем весь мир. Узнайте о 10 Любопытных фактах о китайском драконе.";
            textAboutTheChineseZodiac2 = "Такие врожденные качества, как мужество, упорство и высокий интеллект," +
                    " позволяют Драконам быть на высоте и уверенными в своих силах. Они не боятся трудностей" +
                    " и готовы рискнуть. Однако вместе с тем Драконы раздражительны, несдержанны и редко " +
                    "бывают открыты для критики. Они не любят следовать традициям, предпочитая жить по своим правилам.";
        }
        //Snake
        if (number == 10) {
            dateChineseZodiac = "1941 1953 1965 1977 1989 2001 2013 2025 2027 2049 2061";
            textAboutTheChineseZodiac1 = "В китайской культуре Змея – самое загадочное животное китайского зодиака." +
                    " У людей, родившихся в год Змеи, лучше других развита интуиция. Змеи склонны прислушиваться" +
                    " к собственному мнению, они решительно двигаются к своим целям и ненавидят неудачи. Змеи " +
                    "расчётливы и стремятся к личной выгоде. Любят окружить себя всем самым лучшим, хотя у них" +
                    " редко хватает терпения на длительный шоппинг.";
            textAboutTheChineseZodiac2 = "Змеи представляют собой символ мудрости. Они умны и приятны в общении, но " +
                    "говорят мало. Родившихся в год Змеи обычно воспринимают как великих мыслителей. Люди знака " +
                    "Змеи предпочитают работать в одиночку, поэтому они легко подвержены стрессу. Если напряжение" +
                    " становится более очевидным, то лучше предоставить им личное пространство и время," +
                    " чтобы прийти в себя.";

        }
        //Horse
        if (number == 11) {
            dateChineseZodiac = "1954 1966 1978 1990 2002 2014 2026 2038 2050 2062";
            textAboutTheChineseZodiac1 = "Люди, родившиеся в год Лошади, невероятно увлечённые, активные и энергичные." +
                    " Лошади любят находиться в толпе, их часто можно увидеть на концертах, в театре, на " +
                    "выставках, спортивных мероприятиях и вечеринках.";
            textAboutTheChineseZodiac2 = "У рождённых в год Лошади прекрасное чувство юмора, у них всегда найдётся" +
                    " остроумный ответ. Лошади любят быть в центре внимания и умеют быстро расположить к себе." +
                    "Иногда Лошади бывают немного эгоистичны, но это не значит, что их не волнуют" +
                    " проблемы других. Родившиеся в год Лошади скорее хитрые, чем умные, и, вероятно, поэтому" +
                    " большинству из них не хватает уверенности в себе.";
        }
        //Ram
        if (number == 12) {
            dateChineseZodiac = "1955 1967 1979 1991 2003 2015 2027 2039 2051 2063";
            textAboutTheChineseZodiac1 = "Люди, рождённые в год Козы, как правило, скромные, деликатные, застенчивые," +
                    " стабильные, отзывчивые, дружелюбные; им присущи чувство справедливости и доброта.";
            textAboutTheChineseZodiac2 = "У Козы богатое воображение, она настойчива и легко обучается новым " +
                    "профессиональным навыкам. Хотя родившиеся в год Козы производят впечатление мягких" +
                    " и податливых, они всегда придерживаются своего мнения. Козы любят находиться в обществе," +
                    " но не стремятся быть в центре внимания. Сдержанные и тихие, они всё время в своих мыслях." +
                    " Козы любят одеваться модно, хорошо выглядеть для них очень важно. И хотя Козам по душе " +
                    "изысканные вещи, их нельзя назвать снобами.";
        }
    }
}
