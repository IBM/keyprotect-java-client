**Title**: PR Title

**Short Description**: Short explanation/description of PR (or issue/task)

## Checklist
- [ ] I have performed a self-review of my changes
- [ ] My code/changes are commented (especially hard-to-understand areas)
- [ ] I have written/updated new unit tests for the core changes or new/updated tests are not necessary
- [ ] I have posted test results from local tests or made sure the TravisCI tests succeeded
- [ ] I have made changes to the examples in `examples/kp-sdk-example` where relevant, and tested those changes
      - run `mvn clean install` to build the sdk, then run `mvn clean install` in the `examples/kp-sdk-example` directory to build the examples.
      - To run the example jar's examples, use `java -jar kp-sdk-example-1.0-SNAPSHOT.jar $EXAMPLE_NAME`

## Changes
> _Briefly identify changes made in this PR_
<!-- BEGIN CHANGES -->

<!-- END CHANGES -->

## Test Results

<!-- BEGIN TEST RESULTS -->
Test results may be run by the TravisCI build. If so, please verify whether they are running properly.
<!-- END TEST RESULTS -->

## Dependencies
> _Is anything changing with respect to dependencies (the pom.xml or gradle file)? Explain that here and why they were changed._
<!-- BEGIN DEPENDENCIES -->

<!-- END DEPENDENCIES -->
