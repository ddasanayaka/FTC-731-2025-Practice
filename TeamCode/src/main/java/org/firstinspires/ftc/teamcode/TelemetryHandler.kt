package org.firstinspires.ftc.teamcode

import com.acmerobotics.dashboard.FtcDashboard
import com.acmerobotics.dashboard.canvas.Canvas
import com.acmerobotics.dashboard.telemetry.TelemetryPacket
import org.firstinspires.ftc.robotcore.external.Telemetry

class TelemetryHandler @JvmOverloads constructor(
    private val systemTelemetry: Telemetry? = null,
) {
    private val dashboard: FtcDashboard = FtcDashboard.getInstance()
    private var packet: TelemetryPacket = TelemetryPacket()

    fun addData(key: String, value: Any) {
        packet.put(key, value)
        systemTelemetry?.addData(key, value)
    }

    fun addLine(value: Any) {
        packet.addLine(value.toString())
        systemTelemetry?.addLine(value.toString())
    }

    fun addLine() {
        addLine("")
    }

    fun fieldOverlay(): Canvas = packet.fieldOverlay()

    fun update() {
        dashboard.sendTelemetryPacket(packet)
        systemTelemetry?.update()
        packet = TelemetryPacket()
    }
}
