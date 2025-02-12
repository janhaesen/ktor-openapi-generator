package com.papsign.ktor.openapigen.annotations.type.number.integer.clamp

import com.papsign.ktor.openapigen.annotations.type.number.NumberConstraint
import com.papsign.ktor.openapigen.annotations.type.number.integer.IntegerNumberConstraintProcessor
import com.papsign.ktor.openapigen.model.schema.SchemaModel
import java.math.BigDecimal

object ClampProcessor: IntegerNumberConstraintProcessor<Clamp>() {
    override fun process(
        modelLitteral: SchemaModel.SchemaModelLiteral<*>,
        annotation: Clamp
    ): SchemaModel.SchemaModelLiteral<*> {
        @Suppress("UNCHECKED_CAST")
        return (modelLitteral as SchemaModel.SchemaModelLiteral<Any?>).apply {
            minimum = annotation.min
            maximum = annotation.max
        }
    }

    override fun getConstraint(annotation: Clamp): NumberConstraint {
        return NumberConstraint(BigDecimal(annotation.min), BigDecimal(annotation.max), errorMessage = annotation.errorMessage)
    }
}
