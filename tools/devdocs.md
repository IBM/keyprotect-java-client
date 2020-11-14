# Developer Documentation

This is a document for how to manage and maintain the KeyProtect Java SDK project.


## Creating a new release


### Deploying artifacts to Central

We use the Nexus Staging plugin with Maven as outlined here: https://central.sonatype.org/pages/apache-maven.html

The steps for making a release are as follows:

Make sure your POM version is a release version, with no -SNAPSHOT suffix.

```
...
<version>0.1.2</version>
...
```

Run `mvn clean deploy` to push to a staging Nexus repo in OSSRH

If the deploy is successful you should be able to see the artifacts in temporary repository at https://oss.sonatype.org/#nexus-search;quick~ibm-key-protect-sdk

You can either release these directly from the UI under `Staging Repositories` or use the `mvn nexus-staging:release` target

To go ahead with the release
```
mvn nexus-staging:release
```

To drop the release, if you need to fix something and deploy again
```
mvn nexus-staging:drop
```

The artifacts will then be sync'd to Maven Central after a release.


### Creating tags

We also need to create a tag in the Git repo to track the version of source that was deployed to Central

```
git tag -s 0.1.2
git push origin 0.1.2
```

This will create a signed tag and push it to the origin remote.

### Create a release in Github

After the tag is pushed, a new GH Release can be created from it in the Github UI.
