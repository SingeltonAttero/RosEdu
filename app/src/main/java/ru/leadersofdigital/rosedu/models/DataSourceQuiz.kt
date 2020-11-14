package ru.leadersofdigital.rosedu.models

import ru.leadersofdigital.rosedu.models.model.Quiz
import ru.leadersofdigital.rosedu.models.model.Quiz.SingleAnswerQuiz
import ru.leadersofdigital.rosedu.models.model.Quiz.QuizAnswer

object DataSourceQuiz {
    val quizList:List<Quiz> = listOf(
        SingleAnswerQuiz(1,
            "Как расшифровывается аббревиатура IED?",
            listOf(
                QuizAnswer("Информационно электронное реле",1),
                QuizAnswer("Интеллектуальное устройство учета",2),
                QuizAnswer("Интеллектуальное электронное устройство",3),
                QuizAnswer("Международный энергетический департамент",4)
            ),
            3
        ),
        SingleAnswerQuiz(2,
            "Какие сетевые настройки IED влияют на передачу GOOSE-сообщений?",
            listOf(
                QuizAnswer("MAC –адрес и IP – адрес",1),
                QuizAnswer("IP-адрес и VLAN",2),
                QuizAnswer("MAC-адрес и APPID",3),
                QuizAnswer("Все вместе",4)
            ),
            4
        ),
        SingleAnswerQuiz(3,
            "К какому механизму передачи данных относятся GOOSE-сообщения?",
            listOf(
                QuizAnswer("Клиент-сервер",1),
                QuizAnswer("Master-slave",2),
                QuizAnswer("Издатель-подписчик",3),
                QuizAnswer("Точка-точка",4)
            ),
            3
        ),
        SingleAnswerQuiz(4,
            "Какие первоначальные четыре октета MAC-адреса зарезервировано за ТК57 МЭК?",
            listOf(
                QuizAnswer("01:0D:BB:01",1),
                QuizAnswer("00:0С:ВB:01",2),
                QuizAnswer("01:0С:CD:04",3),
                QuizAnswer("01:0C:CD:01",4)
            ),
            4
        ),
        SingleAnswerQuiz(5,
            "В каком диапазоне можно задавать VLAN для устройств, обменивающихся GOOSE сообщении?",
            listOf(
                QuizAnswer("0-9999",1),
                QuizAnswer("0-4095",2),
                QuizAnswer("0-1000",3),
                QuizAnswer("0-512",4)
            ),
            2
        ),
        SingleAnswerQuiz(6,
            "В какой главе серии стандартов МЭК 61850 описывается механизм передачи GOOSE сообщений?",
            listOf(
                QuizAnswer("МЭК 61850-6",1),
                QuizAnswer("МЭК 61850-7-4",2),
                QuizAnswer("МЭК 61850-8-1",3),
                QuizAnswer("МЭК 61850-9-2",4)
            ),
            3
        ),
        SingleAnswerQuiz(7,
            "Можно ли задавать одинаковые MAC-адреса разным IED?",
            listOf(
                QuizAnswer("Да",1),
                QuizAnswer("Нет",2)
            ),
            2
        ),
        SingleAnswerQuiz(8,
            "Как расшифровывается аббревиатура GOOSE?",
            listOf(
                QuizAnswer("Общее объектно-ориентированное событие на подстанции",1),
                QuizAnswer("Быстрое сообщение релейной защиты",2),
                QuizAnswer("Никак не расшифровывается, это название птицы",3),
                QuizAnswer("Сообщение для передачи объема данных в энергетике",4)
            ),
            1
        ),        SingleAnswerQuiz(9,
            "К какому методу передачи трафика относится GOOSE-сообщения?",
            listOf(
                QuizAnswer("Unicast",1),
                QuizAnswer("Broadcast",2),
                QuizAnswer("Multicast",3)
            ),
            3
        ),
        SingleAnswerQuiz(10,
            "По какому интерфейсу передаются GOOSE – сообщения?",
            listOf(
                QuizAnswer("RS-485",1),
                QuizAnswer("RS-422",2),
                QuizAnswer("Ethernet",3),
                QuizAnswer("RS-232",4)
            ),
            3
        ),
        SingleAnswerQuiz(11,
            "Какое минимальное время между дублирующими GOOSE-сообщениями типа 1А может быть\n" +
                    "установлено согласно «Корпоративному профилю МЭК 61850»?",
            listOf(
                QuizAnswer("4мс",1),
                QuizAnswer("10мс",2),
                QuizAnswer("1мс",3),
                QuizAnswer("1 мкс",4)
            ),
            1
        ),
        SingleAnswerQuiz(12,
            "На каком уровне модели OSI передаются GOOSE – сообщения?",
            listOf(
                QuizAnswer("Канальный",1),
                QuizAnswer("Транспортный",2),
                QuizAnswer("Прикладной",3),
                QuizAnswer("Сетевой",4)
            ),
            1
        ),
        SingleAnswerQuiz(13,
            "Как обозначается устройство на цифровой подстанции передающее/принимающее информации и\n" +
                    "имеющее хотя бы один процессор?",
            listOf(
                QuizAnswer("IED",1),
                QuizAnswer("LED",2),
                QuizAnswer("VMA",3),
                QuizAnswer("STP",4)
            ),
            1
        ),
        SingleAnswerQuiz(14,
            "На каком уровне передается информация посредством GOOSE – сообщений?",
            listOf(
                QuizAnswer("Кольцевой",1),
                QuizAnswer("Горизонтальный",2),
                QuizAnswer("Вертикальный",3),
                QuizAnswer("Сквозной",4)
            ),
            2
        ),
        SingleAnswerQuiz(15,
            "По какому механизму передачи данных работают GOOSE-сообщения?",
            listOf(
                QuizAnswer("TPAA",1),
                QuizAnswer("MCAA",2),
                QuizAnswer("P2P",3),
                QuizAnswer("По всем перечисленным",4)
            ),
            2
        )
    )
}