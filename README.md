# Android Project Github Template

[![platform](https://img.shields.io/badge/platform-Android-yellow.svg)](https://www.android.com)
[![GitHub license](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
![Github Followers](https://img.shields.io/github/followers/happysingh23828?label=Follow&style=social)
![GitHub stars](https://img.shields.io/github/stars/happysingh23828/android-github-repo-template?style=social)
![GitHub forks](https://img.shields.io/github/forks/happysingh23828/android-github-repo-template?style=social)
![GitHub watchers](https://img.shields.io/github/watchers/happysingh23828/android-github-repo-template?style=social)
![Twitter Follow](https://img.shields.io/twitter/follow/happysingh23828?label=Follow&style=social)

> A template for creating new repositories for the new Android Project.

## What is diffrent here from creating a new project from Android Studio?

This repository is meant to serve as a general template for how to set up new repository for Android. In general, setting up a new repository takes 30-60 minutes; use this repository as a way of setting up in 5 minutes, and use the following checklist to ensure that you've set up the repository correctly.
It has additional modules and files to save your time.

### Features
- BuildSrc module (for handling dependecies at one place).
- Core module (includes Kotlin Extensions, Base classess etc.).
- Static tool analysis with Report generation (Ktlint, KtlintAutoFormat Detekt, Custom Detekt Lint Rules).
- Android CI (using Github's Action workflow)
- .gitignore for Android Studio Projects.
- and many more to come....

## Checklist
These instructions are basic; The important part is making sure that you follow the checklist for error free setup.

### Create Repository from Github
- [ ] Click on **use this template** on this repository.
- [ ] Enter your Github repo name.
- [ ] Uncheck **include all branches** option.
- [ ] Click on **create repo from template** button.
now your repo has been created.

### Clone Repo in Android Studio and set up.
- [ ] Clone your newly created github repo into Android Studio.
- [ ] Go to **settings.gradle** and change **rootProject.name** as per your project name.
- [ ] Go to App's **build.gradle** and change **applicationId** as per your project package.
- [ ] Go to App's module **strings.xml** and change **app_name** to your app name.
- [ ] Delete Readme.MD file.
- [ ] [Optional] Go to **themes.xml** and refactor Base Application them's name **Theme.AndroidRepoGithubTemplate** as per your requirements.
that's it.

### Additional Notes
- CI is only triggred on pull request. If you need to change action go to [android-master.yml](https://github.com/happysingh23828/android-github-repo-template/blob/master/.github/workflows/android-master.yml)
- You can edit rules for **Detekt** in this [detekt-rule.yml](https://github.com/happysingh23828/android-github-repo-template/blob/master/app/detekt-rule.yml).

## - Code Quality Checks
This projects uses detekt and ktlint static code analyser in CI/CD pipeline to maintain code quality. they also genrated reports.

  #### Run detekt locally
  Use `./gradlew detekt`

  Reports location for each module-<br>
  `-/app/build/reports/detekt/report.html`<br>
  `-/core/build/reports/detekt/report.html`<br>

  #### Run ktlint locally
  Use `./gradlew ktlint`

  Reports location for each module-<br>
  `-/app/build/reports/ktlint/ktlint-checkstyle-report.xml`<br>
  `-/core/build/reports/ktlint/ktlint-checkstyle-report.xml`<br>

  #### Run ktlint formatter locally
  Use `./gradlew ktlintFormat`


## If this project helps you in anyway, show your love :heart: by putting a :star: on this project :v:


## - Contributing

Please fork this repository and contribute back using
[pull requests](https://github.com/happysingh23828/android-github-repo-template/pulls).

Any contributions, large or small, major features, bug fixes, are welcomed and appreciated
but will be thoroughly reviewed .

### - Contact - Let's become friend
- [Blog](https://happysingh.dev/)
- [Youtube Channel](https://www.youtube.com/channel/UCILhpbLSFkGzsiCYAeR30DA)
- [Github](https://github.com/happysingh23828)
- [Linkedin](https://www.linkedin.com/in/happpysingh23828/)

## - License

```
MIT License

Copyright (c) 2020 Happy Singh

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.```
