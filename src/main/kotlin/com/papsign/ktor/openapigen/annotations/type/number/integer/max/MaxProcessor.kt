package com.papsign.ktor.openapigen.annotations.type.number.integer.max

import com.papsign.ktor.openapigen.annotations.type.number.NumberConstraint
import com.papsign.ktor.openapigen.annotations.type.number.integer.IntegerNumberConstraintProcessor
import com.papsign.ktor.openapigen.model.schema.SchemaModel
import java.math.BigDecimal

object MaxProcessor: IntegerNumberConstraintProcessor<Max>() {
    override fun process(
        modelLitteral: SchemaModel.SchemaModelLiteral<*>,
        annotation: Max
    ): SchemaModel.SchemaModelLiteral<*> {
        @Suppress("UNCHECKED_CAST")
        return (modelLitteral as SchemaModel.SchemaModelLiteral<Any?>).apply {
            maximum = annotation.value
        }
    }
    override fun getConstraint(annotation: Max): NumberConstraint {
        return NumberConstraint(max= BigDecimal(annotation.value), errorMessage = annotation.errorMessage)
    }
}
