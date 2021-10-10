package org.example.demo.spock

import org.spockframework.mock.TooFewInvocationsError
import spock.lang.Specification
import spock.lang.Subject

import javax.swing.Renderer
import java.awt.Polygon

class HashTableSpecification extends Specification {
    def "Should be a simple assertion"() {
        expect:
        1 == 1
    }

    def "should demonstrate given-when-then"() {
        given:
        def polygon = new Polygon(numberOfSides: 4)
        when:
        int sides = polygon.numberOfSides
        then:
        sides == 4
        // Below I am creating an object of another class
        NoCollisionHashTable nCHT = new NoCollisionHashTable();
        int[] values = nCHT.perfectHashFunction();
    }

    def "should expect Exceptions"() {
        when:
        new Polygon(numberOfSides: 0)
        then:
        def exception = thrown(IllegalArgumentException)
    }

    def "should expect an Exception to be thrown for a number of invalid inputs"() {
        when:
        new Polygon(numberOfSides: 0)
        then:
        def exception = thrown(IllegalArgumentException)
        where:
        sides << [-1, 0, 1, 2] // << is the shift operator Intellij runs this test four times
    }

    def "should be able to create a polygon with #sides sides"() {
        when:
        def polygon = new Polygon(sides)
        then:
        polygon.numberOfSides == sides
        where:
        sides << [3, 4, 5, 8, 14]
    }

    def "should use data tables for calculating max"() {
        expect:
        Math.max(a, b) == max
        where:
        a | b | max
        1 | 3 | 3
        7 | 4 | 7
        0 | 0 | 0
    }

    def "should be able to mock a concrete class"() {
        given:
        def renderer = Mock(Renderer)
        @Subject
        def polygon = new Polygon(numberOfSides: 4, renderer)
        when:
        polygon.draw()
        then:
        4 * renderer.drawLine()
    }

    def "should be able to create a stub"() {

    }
}
