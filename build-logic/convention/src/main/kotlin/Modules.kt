object Modules {
    object Core {
        val framework = core("framework")
        val ui = core("ui")
    }

    object Feature {

    }

    object Data {

    }

    private fun core(name: String) = ":core:$name"

    private fun feature(name: String) = ":feature:$name"

    private fun data(name: String) = ":data:$name"
}