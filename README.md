# Game of Life

Conways Spiel des Lebens ist ein beliebter Algorithmus der Automatentheorie. Dabei hat man ein beliebig großes Feld (e.g. 100 x 100 Zellen). Jede der Zelle kann entweder lebendig oder tod sein. Eine Zelle hat immer acht Nachbarzellen (Moor). Die Anfangspopulation wird zufällig gewählt, danach entwickelt sich der Algorithmus in Generationen nach folgenden Regeln:

* ist eine Zelle tot und hat genau 3 lebende Nachbarn, wird sie in der nächsten Generation geboren 👶
* ist eine Zelle am Leben und hat weniger als 2 Nachbarn stirbt sie an Einsamkeit 😔
* ist eine Zelle am Leben und hat 2 oder 3 Nachbarn, bleibt sie am Leben 🤝‍
* ist eine Zelle am Leben und hat mehr als 3 Nachbarn, stirbt sie an Überbevölkerung 💀
