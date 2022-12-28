package com.papsign.ktor.openapigen.annotations.type.string.length

import com.papsign.ktor.openapigen.model.schema.SchemaModel

object MaxLengthProcessor : LengthConstraintProcessor<MaxLength>() {
    override fun process(model: SchemaModel.SchemaModelLiteral<*>, annotation: MaxLength): SchemaModel.SchemaModelLiteral<*> {
        @Suppress("UNCHECKED_CAST")
        return (model as SchemaModel.SchemaModelLiteral<Any?>).apply {
            maxLength = annotation.value
        }
    }

    override fun getConstraint(annotation: MaxLength): LengthConstraint {
        return LengthConstraint(max = annotation.value, errorMessage = annotation.errorMessage)
    }
}