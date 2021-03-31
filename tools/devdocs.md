# Developer Documentation

This is a document for how to manage and maintain the KeyProtect Java SDK project.


## Creating a new release

We use the Nexus Staging plugin with Maven as outlined here: https://central.sonatype.org/pages/apache-maven.html

### Setup

- create gpg key
- export gpg key

don't forget to:
```
export GPG_TTY=$(tty)
```

test signing with
```
mvn verify -P release
```

'verify' target will sign, but only in the release profile
(the snapshot/debug profile is the default, and we don't want developers having to sign
every time they build)

### Testing with SNAPSHOT pushes

If the version in pom.xml is -SNAPSHOT, you can push a snapshot build at any time:
```
mvn deploy
```

When you want to create the real release, follow the further steps below.

### Set the release version

Make sure your POM version is a release version, with no -SNAPSHOT suffix.

```
...
<version>0.1.2</version>
...
```

### Create a signed tag

Create the signed git tag at this point!

Create a signed tag with
```
git tag -s <version>
```

If you hit issues with git not signing, set `GIT_TRACE=1` to get more info
```
GIT_TRACE=1 git tag -s <version>
```

You can push the tag now or wait until after the release.
```
git push origin <version>
```

### Deploying artifacts to Central

To push to a staging Nexus repo in OSSRH
``
`mvn clean deploy -P release
``` 

This should build, sign, and push the artifacts to the Nexus Staging repo.
YOUR BUILD IS NOT PUBLISHED YET

If the deploy is successful you should be able to see the artifacts in temporary repository at https://oss.sonatype.org/#nexus-search;quick~ibm-key-protect-sdk

If the artifacts look OK (have correct version, have signitures, etc)
then you can move along with the release with:
```
mvn nexus-staging:release
```

If it does not look OK, you'll need to drop it with
```
mvn nexus-staging:drop
```

Then go back and fix the issues and redeploy with
```
mvn deploy -P release
```

The artifacts will then be sync'd to Maven Central after a release.

### Create a release in Github

After the tag is pushed, a new GH Release can be created from it in the Github UI.

### Final checklist

- Correct version artifacts published with signitures to SonaType Release repo
- Signed Git tag created and pushed
- Github Release created from tag
- Set new version in pom.xml to <new_version>-SNAPSHOT for new development
- Push new pom.xml version to master
- Backup your GPG key!
