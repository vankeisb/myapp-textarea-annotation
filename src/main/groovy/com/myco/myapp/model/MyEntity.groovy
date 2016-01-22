package com.myco.myapp.model

import com.myco.myapp.facets.Textarea
import org.compass.annotations.Searchable
import org.compass.annotations.SearchableId
import org.compass.annotations.SearchableProperty
import javax.validation.constraints.NotNull

import javax.persistence.Entity
import javax.persistence.Id

@Entity
@Searchable
class MyEntity {

    @Id
    @SearchableId
    Long id

    @NotNull
    @SearchableProperty
    String myProp

    @Textarea
    String myProp2

    Date myOtherProp
}