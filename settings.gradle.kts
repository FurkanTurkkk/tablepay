rootProject.name = "tablepay"

include("bootstrap",
    "table-domain", "table-application", "table-api", "table-infra", "table-composition")

project(":table-domain").projectDir = file("context/table/core/table-domain")
project(":table-application").projectDir = file("context/table/core/table-application")
project(":table-api").projectDir = file("context/table/adapters/in/table-api")
project(":table-infra").projectDir = file("context/table/adapters/out/table-infra")
project(":table-composition").projectDir = file("context/table/table-composition")