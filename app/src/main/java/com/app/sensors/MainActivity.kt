package com.app.sensors

import android.content.Context
import android.hardware.Sensor
import android.hardware.Sensor.TYPE_AMBIENT_TEMPERATURE
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.hardware.SensorManager
import android.util.Log


class MainActivity : AppCompatActivity(),SensorEventListener{

    val sensorManager by lazy {  getSystemService(Context.SENSOR_SERVICE) as SensorManager }
    val TAG = MainActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sensorList = listOf(
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE),
                sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY),
                sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE),
                sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT),
                sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION),
                sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD),
                sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),
                sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE),
                sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY),
                sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY),
                sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR),
                sensorManager.getDefaultSensor(Sensor.TYPE_TEMPERATURE)


                )
        sensorList.forEach { sensorManager.registerListener(this,it,SensorManager.SENSOR_DELAY_NORMAL) }

    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    override fun onSensorChanged(event: SensorEvent?) {
        when(event?.sensor?.type){
            Sensor.TYPE_ACCELEROMETER -> {
               val x = event.values[0]
               val y = event.values[1]
               val z = event.values[2]
               Log.d(TAG,"TYPE_ACCELEROMETER = x : $x , y : $y , z : $z")
            }
            Sensor.TYPE_AMBIENT_TEMPERATURE -> {
                val temp = event.values[0]
                Log.d(TAG,"TYPE_AMBIENT_TEMPERATURE = Temparature : $temp")

            }
            Sensor.TYPE_GRAVITY -> {
                val x = event.values[0]
                val y = event.values[1]
                val z = event.values[2]
                Log.d(TAG,"TYPE_GRAVITY = x : $x , y : $y , z : $z")

            }
            Sensor.TYPE_GYROSCOPE -> {
                val x = event.values[0]
                val y = event.values[1]
                val z = event.values[2]
                Log.d(TAG,"TYPE_GYROSCOPE = x : $x , y : $y , z : $z")
            }
            Sensor.TYPE_LIGHT -> {
                val light = event.values[0]
                Log.d(TAG,"TYPE_LIGHT = light : $light")

            }
            Sensor.TYPE_LINEAR_ACCELERATION -> {
                val x = event.values[0]
                val y = event.values[1]
                val z = event.values[2]
                Log.d(TAG,"TYPE_LINEAR_ACCELERATION = x : $x , y : $y , z : $z")
            }
            Sensor.TYPE_MAGNETIC_FIELD -> {
                val x = event.values[0]
                val y = event.values[1]
                val z = event.values[2]
                Log.d(TAG,"TYPE_MAGNETIC_FIELD = x : $x , y : $y , z : $z")

            }
            Sensor.TYPE_ORIENTATION -> {
                val z = event.values[0] // Azimut (Z ekseni)
                val x = event.values[1] // Pitch  (X ekseni)
                val y = event.values[2] // Roll   (Y ekseni)
                Log.d(TAG,"TYPE_ORIENTATION = x : $x , y : $y , z : $z")

            }
            Sensor.TYPE_PRESSURE -> {
                val pressure = event.values[0]
                Log.d(TAG,"TYPE_PRESSURE = pressure : $pressure")

            }
            Sensor.TYPE_PROXIMITY -> {
                val proximity = event.values[0]
                Log.d(TAG,"TYPE_PROXIMITY = proximity : $proximity")

            }
            Sensor.TYPE_RELATIVE_HUMIDITY-> {
                val humudity = event.values[0]
                Log.d(TAG,"TYPE_RELATIVE_HUMIDITY = humudity : $humudity")

            }
            Sensor.TYPE_ROTATION_VECTOR -> {
                val x = event.values[0]
                val y = event.values[1]
                val z = event.values[2]
                Log.d(TAG,"TYPE_ROTATION_VECTOR = x : $x , y : $y , z : $z")

            }
            Sensor.TYPE_TEMPERATURE -> {
                val temp = event.values[0]
                Log.d(TAG,"TYPE_TEMPERATURE = Temparature : $temp")

            }
        }
    }
}
