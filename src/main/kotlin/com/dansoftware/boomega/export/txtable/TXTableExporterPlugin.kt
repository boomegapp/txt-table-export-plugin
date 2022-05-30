package com.dansoftware.boomega.export.txtable

import com.dansoftware.boomega.export.api.RecordExportAPI
import com.dansoftware.boomega.export.api.RecordExporter
import com.dansoftware.boomega.plugin.RecordExporterPlugin
import com.dansoftware.boomega.util.Person

@Suppress("unused")
@RecordExportAPI
class TXTableExporterPlugin : RecordExporterPlugin {
    override val author: Person = Person(lastName = "Gyoerffy", firstName = "Daniel")
    override val description: String  = "Allows to export records into txt-tables"
    override val name: String = "TXT Table Export Plugin"
    override val version: String = "1.0.0-SNAPSHOT"
    override val exporter: RecordExporter<*> get() = TXTableExporter()

    override fun destroy() { }
    override fun init() { }
}