package com.papsign.ktor.openapigen.annotations.type.string.pattern

import com.papsign.ktor.openapigen.model.schema.SchemaModel

object RegularExpressionProcessor : RegularExpressionConstraintProcessor<RegularExpression>() {
    override fun process(model: SchemaModel.SchemaModelLiteral<*>, annotation: RegularExpression): SchemaModel.SchemaModelLiteral<*> {
        @Suppress("UNCHECKED_CAST")
        return (model as SchemaModel.SchemaModelLiteral<Any?>).apply {
            pattern = annotation.pattern
        }
    }

    override fun getConstraint(annotation: RegularExpression): RegularExpressionConstraint {
        return RegularExpressionConstraint(annotation.pattern, annotation.errorMessage)
    }
}