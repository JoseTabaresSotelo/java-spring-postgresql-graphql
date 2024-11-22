/** @see Package is used as "export default" to enable this class be accessible to other classes in the project*/
package com.ti.blog.entity;

/** @see  imports of each annotation used in the class*/
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

/** @see instead of importing each annotation, use * to access to all annotations in lombok 
 * import lombok.Getter;
 * import lombok.NoArgsConstructor;
 * ...
 * However this approach promotes side effects like: slow down your program, conflict with other packages that use the same namespace (this sample with can import @NonNull from lombok and jakarta), usage more memory, take more time to run the project
*/
/**
 * @see
 * Project Lombok is a java library that automatically plugs into your editor and build tools, spicing up your java.
 * Never write another getter or equals method again, with one annotation your class has a fully featured builder.
 * Java is very couple to Object Oriented Paradigm (OOP) this way use constructor, setter and getter are essential to Java Classes, instead of using a plain POJO (Plain Old Java Object), this class is using annotations to provide better readability and metadata
 */
import lombok.*;

@RequiredArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "sample") //
public class Sample {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    @NonNull
    @Column
    private String sample;

}

/**
 * @see
 * 
 *      Annotations vs Decorators
 *      Spring Boot Annotations are a form of metadata that provides
 *      data about a spring application. Spring Boot is built on the top
 *      of the spring and contains all the features of spring.
 * 
 *      Annotations and decorators are two competing and incompatible
 *      ways to compile the @ symbols that we often see attached to
 *      Angular components.
 *      However Decorator names are providing metadata to the developer
 * 
 *      https://upskilling-training.gitbook.io/better-code/design-patterns/decorator
 *      https://techthoughtsexplorer.hashnode.dev/unleashing-the-power-of-annotations-in-java-a-comprehensive-guide
 * 
 *      However Decorator names are providing metadata to the developer
 */

/**
 * Typescript-NestJS:Field definition to Graphql Schema**
 */
// @IsEmail()
// @IsNotEmpty()
// @MaxLength(100)
// @MinLength(1)
// @Field(type => String)
// private email: string;

/**
 * Java - Spring: Persistence Field to Entity Class
 */
// @Email
// @NotBlank
// @Max(100)
// @Min(1)
// @Column(name = "email")
// private String email;
