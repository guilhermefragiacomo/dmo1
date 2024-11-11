package br.edu.ifsp.dmo.sorteador.model

/*
 * A classe Sorteio (Draw) é reponsável por realizar os sorteios
 * de acordo com uma estratégia definida. Além disso, a classe
 * mantém o histórico dos valores sorteados, impedindo que
 * valores sejam sorteados mais de uma vez.
 */
class Draw(private val border: Int = 0) {
    private lateinit var strategy: SorteioStrategy
    private val history = HashSet<Int>()
    init {
        if (border == 0)
            strategy = DefaultLimit
        else
            strategy = DefinedLimit(border)
    }
    fun getNumber(): Int {
        var number: Int
        do {
            number = strategy.nextNumber()
        } while (!history.add(number))
        return number
    }
    fun getHistory() = ArrayList(history)
    fun getLowBorder() = strategy.getLowBorder()
    fun getHighBorder() = strategy.getHighBorder()
    fun isFull() = border == history.size && border != 0;
}
