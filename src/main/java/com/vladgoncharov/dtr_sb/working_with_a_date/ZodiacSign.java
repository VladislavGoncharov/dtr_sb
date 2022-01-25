package com.vladgoncharov.dtr_sb.working_with_a_date;

import lombok.Data;

import java.time.LocalDate;
import java.util.Map;

@Data
public class ZodiacSign {

    private int day;
    private int month;

    private String zodiacSign;
    private String dateZodiacSign;
    private String textAboutTheZodiacSign1;
    private String textAboutTheZodiacSign2;
    private int imgName;


    private Integer[] daysOfMonth =
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
                    17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
    private Map<Integer, String> monthMap = Map.ofEntries(
            Map.entry(12, "Декабрь"),
            Map.entry(11, "Ноябрь"),
            Map.entry(10, "Октябрь"),
            Map.entry(9, "Сентябрь"),
            Map.entry(8, "Август"),
            Map.entry(7, "Июль"),
            Map.entry(6, "Июнь"),
            Map.entry(5, "Май"),
            Map.entry(4, "Апрель"),
            Map.entry(3, "Март"),
            Map.entry(2, "Февраль"),
            Map.entry(1, "Январь")
    );

    public ZodiacSign() {
    }

    public void getResult() {
        LocalDate checkingTheDate = LocalDate.of(2020, month, day);
        zodiacSign = searchZodiacSing();
    }

    public String searchZodiacSing() {
        switch (month) {
            case 1:
                if (day <= 20) return Capricorn();
                else return Aquarius();
            case 2:
                if (day <= 19) return Aquarius();
                else return Pisces();
            case 3:
                if (day <= 20) return Pisces();
                else return Aries();
            case 4:
                if (day <= 20) return Aries();
                else return Taurus();
            case 5:
                if (day <= 21) return Taurus();
                else return Gemini();
            case 6:
                if (day <= 21) return Gemini();
                else return Cancer();
            case 7:
                if (day <= 22) return Cancer();
                else return Leo();
            case 8:
                if (day <= 21) return Leo();
                else return Virgo();
            case 9:
                if (day <= 23) return Virgo();
                else return Libra();
            case 10:
                if (day <= 23) return Libra();
                else return Scorpio();
            case 11:
                if (day <= 22) return Scorpio();
                else return Sagittarius();
            case 12:
                if (day <= 22) return Sagittarius();
                else return Capricorn();
            default:
                return "Неизвестная дата";
        }
    }

    private String Aries() {
        textAboutTheZodiacSign(1);
        imgName = 1;
        return "Овен";
    }

    private String Taurus() {
        textAboutTheZodiacSign(2);
        imgName = 2;
        return "Телец";
    }

    private String Gemini() {
        textAboutTheZodiacSign(3);
        imgName = 3;
        return "Близнецы";
    }

    private String Cancer() {
        textAboutTheZodiacSign(4);
        imgName = 4;
        return "Рак";
    }

    private String Leo() {
        textAboutTheZodiacSign(5);
        imgName = 5;
        return "Лев";
    }

    private String Virgo() {
        textAboutTheZodiacSign(6);
        imgName = 6;
        return "Дева";
    }

    private String Libra() {
        textAboutTheZodiacSign(7);
        imgName = 7;
        return "Весы";
    }

    private String Scorpio() {
        textAboutTheZodiacSign(8);
        imgName = 8;
        return "Скорпион";
    }

    private String Sagittarius() {
        textAboutTheZodiacSign(9);
        imgName = 9;
        return "Стрелец";
    }

    private String Capricorn() {
        textAboutTheZodiacSign(10);
        imgName = 10;
        return "Козерог";
    }

    private String Aquarius() {
        textAboutTheZodiacSign(11);
        imgName = 11;
        return "Водолей";
    }

    private String Pisces() {
        textAboutTheZodiacSign(12);
        imgName = 12;
        return "Рыбы";
    }

    private void textAboutTheZodiacSign(int number) {
        //Aries
        if (number == 1) {
            dateZodiacSign = "20 марта – 19 апреля";
            textAboutTheZodiacSign1 = "Овен выступает в качестве знака," +
                    " открывающего зодиакальный гороскоп. В момент получения своих названий все знаки зодиака" +
                    " располагались в созвездии Овна. Люди, принадлежащие этому знаку, наделены природной " +
                    "целеустремленностью и мощной внутренней силой. Это позволяет им прокладывать себе путь " +
                    "по жизни в моменты, когда кажется, что дальше возможности двигаться вперед уже нет.";
            textAboutTheZodiacSign2 = "Овен отличается предельной энергичностью, при этом его упрямство и " +
                    "неспособность проявлять гибкость в нужные моменты стали настоящей отличительной меткой " +
                    "рожденных в этот месяц. Даже в случаях, когда требуется добиться поставленных задач любой" +
                    " ценой, знак зодиака Овен не способен пойти на уступки, пусть даже и умышленно. Как " +
                    "результат, они наносят себе множество вреда, особенно в молодости, когда каждому человеку " +
                    "свойственен юношеский максимализм, а горячность возраста вылезает наружу практически постоянно."
                    + "\n" + "К достоинствам Овна можно отнести и оптимизм, позволяющий идти по жизни с " +
                    "уверенностью в завтрашнем дне. Вот только критика со стороны самых близких людей действует на" +
                    " них очень болезненно. Для них важно постоянное поощрение и признание заслуг окружающими.";
        }
        //Taurus
        if (number == 2) {
            dateZodiacSign = "20 апреля – 20 мая";
            textAboutTheZodiacSign1 = "Тельцам свойственно одновременно благородство и " +
                    "независимость. Обладая внушительной силой, они не стремятся демонстрировать ее при первой " +
                    "возможности, выжидая максимально подходящий для этого момент. Жизненный успех сопутствует" +
                    " тельцам только в случае упорства и постоянного труда, а не банального везения или удачи.";
            textAboutTheZodiacSign2 = "В процессе принятия решения " +
                    "Телец никогда не спешит, предпочитая предварительно взвесить все за и против. Лучше всего," +
                    " если они находятся в размышлениях самостоятельно, в противном случае в них проявляется " +
                    "склонность принимать чужие размышления за свои собственные." + "\n" + "Знаки зодиака " +
                    "Телецов характеризуются добротой, при этом в ее проявлении он может демонстрировать " +
                    "излишнюю настойчивость, сочетая ее с неуклюжестью. Свойственно для них и навязывание " +
                    "своего мнения, причем самыми прямолинейными способами. Зачастую более хитрые комбинации " +
                    "представителями этого знака полностью игнорируются. Негативно относясь к лжи, они могут " +
                    "при необходимости использовать ее в личных целях, причем получается это очень достоверно " +
                    "и правдиво." + "\n" + "Практически каждый Телец много внимания уделяет своему внешнему " +
                    "виду. Для него вид успешного и преуспевающего человека играет большую роль, даже если" +
                    " фактически этому статусу он и не соответствует." + "\n" + "Представителям знака свойственна" +
                    " постоянность, даже нереализованные планы будут постоянно храниться в памяти Тельца." +
                    " Друзьями они предпочитают обзаводиться еще в молодости, сохраняя отношения до глубокой " +
                    "старости. Жесткость не является основной чертой характера, но в памяти тельцов обиды " +
                    "остаются на долгие годы.";
        }
        //Gemini
        if (number == 3) {
            dateZodiacSign = "21 мая – 20 июня";
            textAboutTheZodiacSign1 = "Знаки зодиака Близнецы обладают особой двойственностью характера " +
                    "и неспособностью к постоянству. Они практически всегда смотрят на предмет с двух сторон," +
                    " и одновременная любовь с ненавистью к одному человеку для них вполне нормальное явление," +
                    " причем они даже не способны объяснить причины собственных эмоций.";
            textAboutTheZodiacSign2 = "Близнецы успешно сочетают в себе несносность характера и огромную природную " +
                    "обаятельность, дополняемую общительностью. Они много где бывают, поэтому любая беседа " +
                    "оказывается очень интересной и познавательной. Отличаются представители знака и хорошей памятью," +
                    " позволяющей легко запоминать, а потом пересказывать полученные сведения, особенно, " +
                    "не представляющие серьезной важности." + "\n" + "Рожденные в этом месяце, обладают хорошей" +
                    " наблюдательностью, но обратить данное преимущество в собственную сторону не могут. Зачастую" +
                    " это умение даже идет им во вред, так как цепляние к мелочам, не имеющим практического смысла," +
                    " приводит к излишней подозрительности. Даже в самом близком человеке они способны заподозрить" +
                    " угрозу.\n" + "\n" + "Окружающим очень сложно понять Близнецов, причем их поведение может быть " +
                    "принято за лицемерие, хотя это и ошибочное мнение. Судьба постоянно добавляет жизни Близнецов" +
                    " различных испытаний, которые не только не дают расслабиться, но и одновременно закаляют их" +
                    " характер. Причем касается это как материальной стороны, так и духовной.";
            ;
        }
        //Cancer
        if (number == 4) {
            dateZodiacSign = "21 июня – 22 июля";
            textAboutTheZodiacSign1 =
                    "Знаки зодиака Рак обладают в первую очередь повышенной чувствительностью," +
                            " когда даже банальная грубость в свой адрес может стать причиной резкого ухудшения" +
                            " настроения и унынья. При всем при этом внутри них находится мощная энергетика, " +
                            "способная передавать настроение окружающим, причем как плохое, так и хорошее." +
                            "\n" + "Несмотря на подобную ранимость, Рак далеко не всегда пребывает в состоянии " +
                            "страданий и душевных переживаний. Для них свойственно умение ценить" +
                            " юмор и самим отметиться удачной шуткой.";
            textAboutTheZodiacSign2 =
                    "По жизни Раки плывут на волнах, чередуя благоприятные моменты с временными " +
                            "спадами, причем даже на пике успеха они всегда готовы опуститься ниже, чтобы немного" +
                            " передохнуть и набраться сил перед очередным подъемом. Прямой путь напролом через" +
                            " преграды не для них. Значительно чаще и эффективней они пользуются хитростью и измором." +
                            "\n" + "Благородный, обладающий бескорыстностью, Рак не стремится демонстрировать " +
                            "свои качества, что делает его в глазах окружающих эгоистом. С чем нельзя поспорить," +
                            " так это с отношением Рака к своей персоне. Здесь он действительно ценит себя высоко." +
                            " Любовь к славе известная слабость Раков, причем воспринимается она ими не как заслуга," +
                            " а само собой разумеющееся явление, причем ее значение для представителей знака " +
                            "даже больше, чем материальная обеспеченность." + "\n" + "Светская жизнь не для " +
                            "них. Значительно больше Раки предрасположены к семейной жизни, причем с родными " +
                            "он отличается щедростью, что особенно заметно на контрасте с окружающими.";
        }
        //Leo
        if (number == 5) {
            dateZodiacSign = "23 июля – 22 августа";
            textAboutTheZodiacSign1 = "Знаки зодиака Лев, это в первую очередь сочетание амбициозности и лени. " +
                    "Всю свою жизнь представители знака стремятся занять как можно более высокое положение в " +
                    "обществе и обеспечить себе материальный достаток, вот только ждут, что все это упадет на " +
                    "голову само собой, и ничего предпринимать не потребуется." + "\n" + "Со своим окружением Лев" +
                    " обходится как «царь зверей», наблюдая несколько свысока. Любая критика в собственный адрес " +
                    "при этом воспринимается болезненно, так как поступает она от людей, не имеющих права обсуждать" +
                    " «самого» Льва.";
            textAboutTheZodiacSign2 =
                    "Для представителей этого знака свойственно наличие большого количества знакомых," +
                    " но большая часть из них не более чем полезные связи, в то время как количество действительно " +
                    "близких людей минимально. От такой манеры поведения им иногда достается, но учиться на своих " +
                    "ошибках они не хотят, да и не умеют. В любой победе Лев обязательно видит только собственные " +
                    "заслуги, в то время как виновниками неудач становится судьба или окружающие люди." + "\n" +
                    "Каждый Лев материалист, для которого материальные и духовные блага никогда не будут стоять на " +
                    "одном уровне. Именно материальный достаток является целью всей жизни, к которой следует " +
                    "продвигаться в любой ситуации.";
        }
        //Virgo
        if (number == 6) {
            dateZodiacSign = "23 августа – 22 сентября";
            textAboutTheZodiacSign1 = "Со стороны кажется, что Девы никогда не способны вырваться из череды" +
                    " бытовых проблем, но это не больше, чем визуальный эффект. Знаки зодиака Дева отличаются " +
                    "отличной наблюдательностью, выявляя все изъяны, существующие в нашей жизни. Там, где исправить " +
                    "их имеется возможность, Дева обязательно попробует это сделать." + "\n" +
                    "Представители этого знака обладают склонностью к поддержанию чистоты, причем стремятся " +
                    "сделать лучше не только собственный уголок, но и распространить его на весь мир.";
            textAboutTheZodiacSign2 = "Представители этого знака обладают склонностью к поддержанию чистоты, причем " +
                    "стремятся сделать лучше не только собственный уголок, но и распространить его на весь мир." +
                    "\n" + "Для них свойственно наличие природного ума, развитой интуиции и умения анализировать " +
                    "ситуацию. Вот только их язвительные замечания в адрес окружающих очень часто становятся " +
                    "причиной обид и недовольства со стороны близких людей." + "\n" + "Вне зависимости от темы Дева " +
                    "имеет собственный взгляд на вещи, но защищать его в дискуссии они предпочитают только с " +
                    "оппонентами, равными себе по уровню и статусу. Разговаривать, и что-то доказывать человеку " +
                    "недальновидному, Дева никогда не станет, считая подобный спор пустой тратой времени." + "\n" +
                    "Для многих из них свойственна привлекательность, которая при наличии соответствующего желания " +
                    "превращается в настоящую неотразимость. Но выделяться из публики Девы не любят, оставаясь " +
                    "до последнего момента «серой мышкой». Не удивительно, что многие их изначально недооценивают."
                    + "\n" + "Спокойные и рассудительные, они очень быстро заводятся в ситуациях, когда сталкиваются "+
                    "с хамством или глупостью. Этого вполне достаточно, чтобы со всей яростью наброситься на " +
                    "противника." + "\n" + "В материальном плане это очень расчетливые люди предпочитающие " +
                    "обходиться без долгов, и тратить средства предельно разумно.";

        }
        //Libra
        if (number == 7) {
            dateZodiacSign = "23 сентября – 22 октября";
            textAboutTheZodiacSign1 = "Знаки зодиака Весы отличаются в первую очередь скромностью и обаянием. " +
                    "Его представители не склонны наносить обиды окружающим, и не обижаются на каждое неприятное " +
                    "слово в собственный адрес. Опираясь на интуицию, они очень часто оказываются способны " +
                    "найти оптимальный вариант действий, предсказать развитие ситуации в будущем." +
                    "\n" + "Веселые и общительные по жизни, в некоторые моменты за счет переменчивости характера " +
                    "способны перевоплощаться в чудовищ. Нервные, постоянно раздраженные, и при этом капризные, " +
                    "они способны вывести из себя абсолютно любому человеку. Именно в этот период " +
                    "Весы чаще всего лишаются друзей и знакомых.";
            textAboutTheZodiacSign2 = "Нет у людей, рожденных в этот период, и жизненного постоянства. Периоды " +
                    "высокой активности и работоспособности периодически сменяются полной апатией и безразличием" +
                    " к происходящему вокруг. Только чтение остается единственным занятием, тяга к которому" +
                    " проявляется у весов постоянно и без ограничений. Зачастую даже сложная научная " +
                    "литература становится для них источником умиротворения и настоящего отдыха." + "\n" +
                    "Весы понимают собственное непостоянство, поэтому стремятся по жизни опираться на " +
                    "«рациональное зерно», взвешивать все решения и поступки. Вот только зачастую, они становятся " +
                    "заложниками мнений других людей, даже не понимая, что оказались в зависимости. Обладая " +
                    "отменной интуицией, Весы очень редко ей пользуются, а это, ключ к их жизненному успеху.";
        }
        //Scorpio
        if (number == 8) {
            dateZodiacSign = "23 октября – 21 ноября";
            textAboutTheZodiacSign1 = "Знаки зодиака Скорпион наиболее интересны для исследования специалистами." +
                    " Именно представители этого зодиакального символа обладают наибольшей широтой разнообразия " +
                    "характеров. Среди Скорпионов встречают и материалисты, и верящие в потусторонний мир, " +
                    "и настоящие гении, и уникальные глупцы. Всех их объединяет только одно, они очень интересные," +
                    " но и очень опасные люди. Именно поэтому нужно всегда следить, чтобы их жало не оказалось " +
                    "направлено на вас." + "\n" + "Мнения других людей для них не существует, в то время как " +
                    "свое собственное Скорпионы стремятся высказываться при первом подвернувшемся случае, даже" +
                    " тогда, когда целесообразнее было бы промолчать. Их уверенность в собственной правоте" +
                    " приводит к тому, что даже общепринятые аксиомы подвергаются сомнению, причем убедить" +
                    " их в обратном не представляется возможным. Не известно им и такое слово как компромисс, " +
                    "поэтому рассчитывать на какие-то уступки с их стороны было бы наивно.";
            textAboutTheZodiacSign2 = "Многие специалисты в области астрологии выделяют три типа " +
                    "скорпионов. Классические «ядовитые» отличаются злобой, алчностью, агрессивностью. " +
                    "Благородные скорпионы всегда готовы прийти на помощь, отличаются справедливостью и " +
                    "здравомыслием. Есть еще «серые ящерицы». По своему характеру они относятся к числу" +
                    "ядовитых представителей, но их духовная слабость не позволяет реализоваться на практике. " +
                    "В результате, они лишь копят в себе злобу на окружающих, и способны сделать" +
                    " гадость даже близкому человеку.";
        }
        //Sagittarius
        if (number == 9) {
            dateZodiacSign = "23 октября – 21 ноября";
            textAboutTheZodiacSign1 = "Открытые, общительные, умные и жизнерадостные, Стрельцы в большинстве случаев" +
                    " находятся в отличном расположении духа. Зачастую они всю жизнь предпочитают активный образ" +
                    " жизни, причем касается это не только тела, но и ума. Знаки зодиака Стрелец отличаются " +
                    "свободолюбием и очень болезненно переносит любые ограничения, возникающие на жизненном пути.";
            textAboutTheZodiacSign2 = "Искренние люди, предпочитающие добросовестно относиться к своим обязанностям," +
                    " они обладают излишней импульсивностью, зачастую идущей во вред личным интересам. Постоянные " +
                    "метания между крайности позволяют Стрельцам с завидной регулярностью обзаводиться врагами и" +
                    " недоброжелателями. Очень часто представители этого знака стремятся отстоять чужие интересы," +
                    " испытывая глубокие чувства ответственности. Опека в их исполнении способна превратиться в" +
                    " досаждающее мероприятие." + "\n" + "В целом все Стрельцы делятся на две категории. Одну" +
                    " формируют идеалисты, преисполненные благородства к окружающим. Вторую образуют " +
                    "изворотливые финансисты, для которых власть любыми средствами смысл жизни. Представителей " +
                    "последней группы обоснованно считают снобами, способными на любую лесть, но их это " +
                    "практически не волнует."+"\n" + "Критика вообще не волнует представителей знака, " +
                    "оставаясь вне их ушей. Причем реакция на критика будет отрицательной, в то время как человек," +
                    " не обсуждающий действия Стрельца, получает взамен очень теплые и дружественные отношения.";
        }
        //Capricorn
        if (number == 10) {
            dateZodiacSign = "22 декабря – 20 января";
            textAboutTheZodiacSign1 = "Знаки зодиака Козерог демонстрируют образец стойкости и целеустремленности." +
                    " Люди, родившиеся в этот период зимы, стремятся достичь любой поставленной цели " +
                    "вне зависимости от степени ее важности. Зачастую они обладают развитым мышлением, и при" +
                    " отсутствии природной лени готовы проявлять свои способности при любой возможности. Учиться " +
                    "Козероги готовы всегда, даже будучи в зрелом возрасте.";
            textAboutTheZodiacSign2 = "Гордость и независимость существенно ограничивают возможности Козерогов " +
                    "по адаптации в обществе. Часто они оказываются неспособны понравиться окружающим, завести" +
                    " новых друзей и знакомых. В тоже время, серьезной проблемой для них это не" +
                    " является, благо небольшой круг близких друзей является оптимальным вариантом взаимодействия" +
                    " с обществом для знака. Кроме того, очень часто они преднамеренно выбирают одиночество, " +
                    "не желая общения с незнакомыми людьми." + "\n" + "В большинстве случаев Козерог является " +
                    "классическим эгоистом, не стремящимся поставить себя выше, чем находятся окружающие люди." +
                    " Комплексы и обида на окружающих за собственную недооцененность являются " +
                    "распространенной проблемой для представителей знака." + "\n" + "Козероги стремятся к власти, " +
                    "но успешно маскируют это желание за кажущимся спокойствием. Зачастую, получая власть, и не " +
                    "сдерживаясь моральными принципами, они становятся настоящими тиранами.";

        }
        //Aquarius
        if (number == 11) {
            dateZodiacSign = "21 января – 18 февраля";
            textAboutTheZodiacSign1 = "Знак зодиака Водолей предполагает наличие у человека очень ранимой души." +
                    " Представители знака могут иметь массу знакомых, но при этом действительно близких людей, " +
                    "которым они способны открыть душу, насчитывается минимальное количество. Любопытно, но " +
                    "в друзьях у них всегда находятся люди с неуравновешенным, неспокойным характером, которые" +
                    " постоянно попадают в какие-либо проблемы.";
            textAboutTheZodiacSign2 = "Водолей сам по себе очень дружелюбный, но, не зная чувства меры, " +
                    "он может легко перейти границы допустимого, превращаясь в навязчивого человека." +
                    " Придерживаясь собственного мнения, они поддаются уговорам, если видят, что мнение оппонента" +
                    " более разумное и обоснованное. Вот только доводить Водолея до состояния обиды не стоит," +
                    " он практически гарантировано будет мстить, причем " +
                    "столь долго, сколько потребуется для достижения поставленной цели." + "\n" + "Выделяет их " +
                    "на фоне других людей и повышенное любопытство. Не существует ни одной темы, куда бы " +
                    "представители знака не постарались «засунуть нос». Подобная особенность не позволяет им" +
                    " сосредотачиваться на одном деле, распыляя энергию. Способность впитывать информацию " +
                    "делает из некоторых гениев, но значительно чаще они оказываются в числе " +
                    "пациентов психиатрических клиник.";

        }
        //Pisces
        if (number == 12) {
            dateZodiacSign = "19 февраля – 19 марта";
            textAboutTheZodiacSign1 = "Рыбы знак интересный. Интересный в первую очередь способностью полноценно" +
                    " оценивать себя и свои возможности, находить достоинства и недостатки. За счет " +
                    "того, что себя Рыбы знают досконально, они способны подходить к самооценке с достаточной " +
                    "" +
                    "степенью ироничности.";
            textAboutTheZodiacSign2 = "Знаки зодиака Рыбы не совместимы с постоянством. Любое обещание может " +
                    "быть забыто, а точка зрения способна меняться несколько раз в течение одного дня. " +
                    "Они хорошо относятся к дружбе, но уверены, что интересы друзей можно при необходимости" +
                    " проигнорировать. Ложь из их уст является само собой разумеющимся явлением, причем с ее " +
                    "помощью они стремятся превознести себя в глазах окружающих, или же просто " +
                    "делают это без какой-либо обоснованной причины." + "\n" + "Со стороны представители этого " +
                    "знака могут показаться слабыми, но это не больше чем обман, которые сами же Рыбы " +
                    "стремятся усилить. В своем большинстве они отличаются ленью, предпочитая строить замки" +
                    " в мечтаниях, чем создавать их на земле упорным трудом. Ко всему, материальные богатства " +
                    "для них играют второстепенную роль, уступая по важности духовному развитию." + "\n" +
                    "В среде Рыб можно встретить слабых и зависимых представителей, на которых предельно легко " +
                    "оказать влияние, особенно негативное. В результате, такая" +
                    " зависимость способна довести даже до тюрьмы.";
        }
    }
}
