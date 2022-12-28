package com.papsign.ktor.openapigen.annotations.type.number.floating.min

import com.papsign.ktor.openapigen.annotations.type.number.NumberConstraint
import com.papsign.ktor.openapigen.annotations.type.number.floating.FloatingNumberConstraintProcessor
import com.papsign.ktor.openapigen.model.schema.SchemaModel
import java.math.BigDecimal

object FMinProcessor: FloatingNumberConstraintProcessor<FMin>() {
    override fun process(
        modelLitteral: SchemaModel.SchemaModelLiteral<*>,
        annotation: FMin
    ): SchemaModel.SchemaModelLiteral<*> {
        @Suppress("UNCHECKED_CAST")
        return (modelLitteral as SchemaModel.SchemaModelLiteral<Any?>).apply {
            minimum = annotation.value
        }
    }

    override fun getConstraint(annotation: FMin): NumberConstraint {
        return NumberConstraint(min = BigDecimal(annotation.value), errorMessage = annotation.errorMessage)
    }
}
