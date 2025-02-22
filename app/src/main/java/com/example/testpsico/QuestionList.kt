package com.example.testpsico

import kotlin.random.Random

class QuestionList(private val type: String?) {

    private var questionList = ArrayList<Pair<String,Int>>(10)
    private var questionDataList = ArrayList<Question>(10)
    private var correctAnswer = ""

    private fun setQuestionList()
    {
        when(type)
        {
            "easy"-> {
                for (i in 1..10)
                    questionList.add(Zung.getQuestions())
            }
            "medium"-> {
                for (i in 1..10)
                    questionList.add(Beck.getQuestions())
            }
        }
    }

    private fun getOption(position:Int):ArrayList<String>
    {
        val optionList = ArrayList<String>(4)
        var answer = questionList[position].second
        if (answer!=7777777)
        {
            correctAnswer = answer.toString()
            optionList.add(answer.toString())
            optionList.add((answer+ Random.nextInt(-9,10)).toString())
            optionList.add((answer+ Random.nextInt(-9,10)).toString())
            optionList.add("NA")
        }
        else
        {
            correctAnswer = "NA"
            answer = Random.nextInt(1,4000)
            optionList.add((answer+ Random.nextInt(-9,10)).toString())
            optionList.add((answer+ Random.nextInt(-9,10)).toString())
            optionList.add((answer+ Random.nextInt(-9,10)).toString())
            optionList.add("NA")
        }
        optionList.shuffle()
        return optionList
    }

    fun getQuestionsList():ArrayList<Question>
    {
        setQuestionList()
        for ( i in 0..9)
        {
            val optionList = getOption(i)
            val question = Question(
                questionList[i].first,
                correctAnswer,
                optionList[0],
                optionList[1],
                optionList[2],
                optionList[3],
                "none"
            )
            questionDataList.add(question)
        }
        return questionDataList
    }

}