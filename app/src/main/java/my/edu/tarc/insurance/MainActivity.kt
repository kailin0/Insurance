package my.edu.tarc.insurance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import my.edu.tarc.insurance.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener {
            var premium: Int = 0
            var extra: Int = 0
            var total: Int = 0
            //Position start from 0..n-1
            val age = binding.spinnerAge.selectedItemPosition
            val gender = binding.radioGroupGender.checkedRadioButtonId
            val smoker = binding.checkBoxSmoker.isChecked
            if(age == 0){   //Less than 17
                premium = 60
            } else if(age == 1){
                premium = 70
                if(gender == binding.radioButtonMale.id){
                    extra += 50
                }
                if(smoker){
                    extra += 100
                }
            } else if(age == 2){
                premium = 90
                if(gender == binding.radioButtonMale.id){
                    extra += 100
                }
                if(smoker){
                    extra += 150
                }
            } else if(age == 3){
                premium = 120
                if(gender == binding.radioButtonMale.id){
                    extra += 150
                }
                if(smoker){
                    extra += 200
                }
            } else if(age == 4){
                premium = 150
                if(gender == binding.radioButtonMale.id){
                    extra += 200
                }
                if(smoker){
                    extra += 250
                }
            } else{
                premium = 150
                if(gender == binding.radioButtonMale.id){
                    extra += 200
                }
                if(smoker){
                    extra += 300
                }
            }

            total = premium + extra
            binding.myPremium = Premium(premium, extra, total)
        }

        binding.buttonReset.setOnClickListener {
            binding.spinnerAge.setSelection(0)
            binding.radioGroupGender.clearCheck()
            binding.checkBoxSmoker.isChecked = false
            binding.myPremium = Premium()
        }
    }
}