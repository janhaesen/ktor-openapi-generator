package com.papsign.ktor.openapigen.annotations.type.number.floating.clamp

import com.papsign.ktor.openapigen.annotations.type.number.NumberConstraint
import com.papsign.ktor.openapigen.annotations.type.number.floating.FloatingNumberConstraintProcessor
import com.papsign.ktor.openapigen.model.schema.SchemaModel
import java.math.BigDecimal

object FClampProcessor : FloatingNumberConstraintProcessor<FClamp>() {
    override fun process(
        modelLitteral: SchemaModel.SchemaModelLiteral<*>,
        annotation: FClamp
    ): SchemaModel.SchemaModelLiteral<*> {
        @Suppress("UNCHECKED_CAST")
        return (modelLitteral as SchemaModel.SchemaModelLiteral<Any?>).apply {
            minimum = annotation.min
            maximum = annotation.max
        }
    }

    override fun getConstraint(annotation: FClamp): NumberConstraint {
        return NumberConstraint(BigDecimal(annotation.min), BigDecimal(annotation.max), errorMessage = annotation.errorMessage)
    }
}
