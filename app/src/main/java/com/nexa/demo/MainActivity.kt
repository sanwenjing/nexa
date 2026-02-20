package com.nexa.demo

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ai.nexa.sdk.NexaSdk
import ai.nexa.sdk.vlm.VlmWrapper
import ai.nexa.sdk.vlm.VlmCreateInput
import ai.nexa.sdk.vlm.ModelConfig
import ai.nexa.sdk.vlm.GenerationConfig
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity ){

    
    private var vlmWrapper: VlmWrapper? = null
    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NexaSdk.getInstance().init(this)

        resultText = findViewById(R.id.resultText)
        val generateButton = findViewById<Button>(R.id.generateButton)

        generateButton.setOnClickListener {
            generateResponse()
        }

        loadModel()
    }

    private fun loadModel() {
        resultText.text = "ºjª9è%ùbª:/oy.+K‹‹ˆ‚‚ˆ›UÜ˜\\‹˜Z[\Š
Bˆ›PÜ™X]R[œ]
ˆ›PÜ™X]R[œ]
ˆ[Ù[˜[YHH›Û[šK[™]\˜[‹ˆ[Ù[]H‹Ù]KÙ]KØÛÛK›™^K™[[ËÙš[\ËÛ[Ù[ËÈ‹ˆÛÛ™šYÈH[Ù[ÛÛ™šYÊˆX^ÚÙ[œÈHŒˆ[˜X›U[šÚ[™ÈH˜[ÙBˆ
KˆYÚ[’YH›œH‚ˆ
Bˆ
K˜Z[

Bˆ›Û”ÝXØÙ\ÜÈÈ›HO‚ˆ›UÜ˜\\ˆH›Bˆ[“Û•ZU™XYÂˆ™\Ý[^^Hj¨yg¢ùb¨:/oy¢$9b§þûÈBˆBˆBˆ›Û‘˜Z[\™HÈ\œ›ÜˆO‚ˆ[“Û•ZU™XYÂˆ™\Ý[^^H9bª:/oyi,z-)Nˆ	Ù\œ›Ü‹›Y\ÜØYÙ_H‚ˆBˆBˆB‚ˆš]˜]H[ˆÙ[™\˜]T™\ÜÛœÙJ
HÂˆ˜[[œ]^Hš[™šY]ÐžRY
[™›ÚYÚYÙ]‘Y]^Š‹šYš[œ]^
K^ÔÝš[™Ê
BˆYˆ
[œ]^š\Ñ[\J
JHÂˆ™\Ý[^^H²¯-ú+çùa¤¹¥—ºh¡ˆ"
            return
        }

        resultText.text = "å”Ÿæˆä¸­..."

        vlmWrapper?.let { vlm ->
            CoroutineScope(Dispatchers.Maii.launch {
                vlm.generateStreamFlow(inputText, GenerationConfig())
                    .collect { result ->
                        resultText.text = result
                    }
            }
        } : run {
            resultText.text = "æ–‡æ~¬åŠ è½½"
        }
    }
}
