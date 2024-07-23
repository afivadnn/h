package com.afivadnan.h
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import net.objecthunter.exp4j.ExpressionBuilder


class ThirdFragment : Fragment() {

    private lateinit var solutionTV : TextView
    private lateinit var resultTV : TextView
    private lateinit var btn_t : TextView
    private lateinit var btn_a : TextView
    private lateinit var btn_b : TextView
    private lateinit var btn_div : TextView
    private lateinit var btn_mlt : TextView
    private lateinit var btn_sub : TextView
    private lateinit var btn_add : TextView
    private lateinit var btn_clear : TextView
    private lateinit var btn_del : TextView
    private lateinit var btn_res : TextView
    private lateinit var btn_1 : TextView
    private lateinit var btn_2 : TextView
    private lateinit var btn_3 : TextView
    private lateinit var btn_4 : TextView
    private lateinit var btn_5 : TextView
    private lateinit var btn_6 : TextView
    private lateinit var btn_7 : TextView
    private lateinit var btn_8 : TextView
    private lateinit var btn_9 : TextView
    private lateinit var btn_0 : TextView
    private var op :String=""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
    }

    private fun add(value: String) {
        if (value == "." && solutionTV.text.isNotEmpty()) {
            val lastNumber = solutionTV.text.split(Regex("[+\\-*/]")).last()
            if (lastNumber.contains(".")) {
                return
            }
        }

        solutionTV.text = solutionTV.text.toString() + value
        op = solutionTV.text.toString()
    }

    private fun initView(view: View) {
        solutionTV = view.findViewById(R.id.solutionTV)
        resultTV = view.findViewById(R.id.resultTV)
        btn_t = view.findViewById(R.id.btn_t)
        btn_a = view.findViewById(R.id.btn_a)
        btn_b = view.findViewById(R.id.btn_b)
        btn_div = view.findViewById(R.id.btn_div)
        btn_del = view.findViewById(R.id.btn_del)
        btn_mlt = view.findViewById(R.id.btn_mlt)
        btn_sub = view.findViewById(R.id.btn_sub)
        btn_add = view.findViewById(R.id.btn_add)
        btn_clear = view.findViewById(R.id.clear_btn)
        btn_res = view.findViewById(R.id.btn_res)
        btn_1 = view.findViewById(R.id.btn_1)
        btn_2 = view.findViewById(R.id.btn_2)
        btn_3 = view.findViewById(R.id.btn_3)
        btn_4 = view.findViewById(R.id.btn_4)
        btn_5 = view.findViewById(R.id.btn_5)
        btn_6 = view.findViewById(R.id.btn_6)
        btn_7 = view.findViewById(R.id.btn_7)
        btn_8 = view.findViewById(R.id.btn_8)
        btn_9 = view.findViewById(R.id.btn_9)
        btn_0 = view.findViewById(R.id.btn_0)

        btn_a.setOnClickListener { add("(") }
        btn_b.setOnClickListener { add(")") }
        btn_t.setOnClickListener { add(".") }
        btn_1.setOnClickListener { add("1") }
        btn_2.setOnClickListener { add("2") }
        btn_3.setOnClickListener { add("3") }
        btn_4.setOnClickListener { add("4") }
        btn_5.setOnClickListener { add("5") }
        btn_6.setOnClickListener { add("6") }
        btn_7.setOnClickListener { add("7") }
        btn_8.setOnClickListener { add("8") }
        btn_9.setOnClickListener { add("9") }
        btn_0.setOnClickListener { add("0") }
        btn_div.setOnClickListener { add("/") }
        btn_mlt.setOnClickListener { add("*") }
        btn_sub.setOnClickListener { add("-") }
        btn_add.setOnClickListener { add("+") }
        btn_clear.setOnClickListener {
            solutionTV.text = ""
            resultTV.text = ""
            op = ""
        }
        btn_del.setOnClickListener {
            val length = solutionTV.text.length
            if (length > 0) {
                solutionTV.text = solutionTV.text.subSequence(0, length - 1)
                op = solutionTV.text.toString()
            }
        }
        btn_res.setOnClickListener { calculateResult() }
    }

    private fun calculateResult() {
        try {
            val expression = ExpressionBuilder(op).build()
            val result = expression.evaluate()
            resultTV.text = result.toString()
        } catch (e: Exception) {
            resultTV.text = "Error"
        }
    }
}
