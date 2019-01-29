package me.taromati.exercisetimer.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import kotlinx.android.synthetic.main.activity_input.*
import me.taromati.exercisetimer.R
import me.taromati.exercisetimer.picker.NumberPickerDialog

class InputActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        buttonExerciseTime.setOnClickListener {
            val dialog = NumberPickerDialog()
            val args = Bundle()
            args.putInt("minValue", 10)
            args.putInt("maxValue", 3600)
            args.putInt("step", 10)
            args.putInt("currentValue", textViewExerciseTime.text.toString().toInt())
            dialog.arguments = args

            val fm = supportFragmentManager
            fm.registerFragmentLifecycleCallbacks(object : FragmentManager.FragmentLifecycleCallbacks() {
                override fun onFragmentViewDestroyed(fm: FragmentManager, f: Fragment) {
                    super.onFragmentViewDestroyed(fm, f)

                    textViewExerciseTime.text = dialog.selectedValue.toString()

                    fm.unregisterFragmentLifecycleCallbacks(this)
                }
            }, false)
            dialog.show(fm, "Exercise")
        }

        buttonRestTime.setOnClickListener {
            val dialog = NumberPickerDialog()
            val args = Bundle()
            args.putInt("minValue", 10)
            args.putInt("maxValue", 3600)
            args.putInt("step", 10)
            args.putInt("currentValue", textViewRestTime.text.toString().toInt())
            dialog.arguments = args

            val fm = supportFragmentManager
            fm.registerFragmentLifecycleCallbacks(object : FragmentManager.FragmentLifecycleCallbacks() {
                override fun onFragmentViewDestroyed(fm: FragmentManager, f: Fragment) {
                    super.onFragmentViewDestroyed(fm, f)

                    textViewRestTime.text = dialog.selectedValue.toString()

                    fm.unregisterFragmentLifecycleCallbacks(this)
                }
            }, false)
            dialog.show(fm, "Exercise")
        }

        buttonRepeatTimes.setOnClickListener {
            val dialog = NumberPickerDialog()
            val args = Bundle()
            args.putInt("minValue", 1)
            args.putInt("maxValue", 100)
            args.putInt("step", 1)
            args.putInt("currentValue", textViewRepeatTimes.text.toString().toInt())
            dialog.arguments = args

            val fm = supportFragmentManager
            fm.registerFragmentLifecycleCallbacks(object : FragmentManager.FragmentLifecycleCallbacks() {
                override fun onFragmentViewDestroyed(fm: FragmentManager, f: Fragment) {
                    super.onFragmentViewDestroyed(fm, f)

                    textViewRepeatTimes.text = dialog.selectedValue.toString()

                    fm.unregisterFragmentLifecycleCallbacks(this)
                }
            }, false)
            dialog.show(fm, "Exercise")
        }

        buttonStart.setOnClickListener {

        }
    }
}
