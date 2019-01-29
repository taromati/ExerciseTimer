package me.taromati.exercisetimer.picker
import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.NumberPicker

import me.taromati.exercisetimer.R

class NumberPickerDialog : DialogFragment() {
    private var minValue: Int = 0
    private var maxValue: Int = 0
    private var step: Int = 0
    var selectedValue: Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_number_picker_dialog, container, false)

        minValue = arguments!!.getInt("minValue")
        maxValue = arguments!!.getInt("maxValue")
        step = arguments!!.getInt("step")
        selectedValue = arguments!!.getInt("currentValue")

        val numberPicker = view.findViewById<NumberPicker>(R.id.numberPicker)
        numberPicker.wrapSelectorWheel = false
        numberPicker.descendantFocusability = NumberPicker.FOCUS_BLOCK_DESCENDANTS

        numberPicker.minValue = 0
        numberPicker.maxValue = (maxValue - minValue) / step
        numberPicker.displayedValues = getArrayWithSteps(minValue, maxValue, step)
        numberPicker.value = (selectedValue - minValue) / step

        numberPicker.setOnValueChangedListener { _, _, newVal -> selectedValue = newVal * step + minValue }

        return view
    }

    fun getArrayWithSteps(min: Int, max: Int, step: Int): Array<String?> {
        val size = (max - min) / step + 1

        val result = arrayOfNulls<String>(size)
        for (i in 0 until size) {
            result[i] = (min + step * i).toString()
        }
        return result
    }

}// Required empty public constructor
