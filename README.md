<h1 align="center">SmartHome, IoT</h1>

<!-- <p align="center">
<a href="https://npmjs.org/package/enquirer">
<img src="https://img.shields.io/npm/v/enquirer.svg" alt="version">
</a>
<a href="https://travis-ci.org/enquirer/enquirer">
<img src="https://img.shields.io/travis/enquirer/enquirer.svg" alt="travis">
</a>
<a href="https://npmjs.org/package/enquirer">
<img src="https://img.shields.io/npm/dm/enquirer.svg" alt="downloads">
</a>
</p> -->

<br>
<br>

<p align="center">
<b>SmartHome IoT Application, 2019 Mobile Programming Project</b><br>
<sub>>_ Ajou University Media 조경선 허준영 김민형▌<sub>
</p>

<br>

<p align="center">
<img src= "Application/src/main/res/drawable-mdpi/logo.png" alt="Application Logo" width="300">
</p>


## ❯ Getting started

Application for handle IoT service, based on Bluetooth service with Resberry Pi. 

* [Install](#-install)
* [Usage](#-usage)
* [SmartHome,IoT](#-SmartHome,IoT)
* [Rasberry Pi](#-Raberry-Pi)
* [Options](#-options)
* [Release History](#-release-history)
* [Performance](#-performance)
* [QnA](#-QnA)
* [About](#-about)

<br>


<br>
<!-- <br>

Please consider starting or tweeting about this project to show your support. Thanks!

Created by [jonschlinkert](https://github.com/jonschlinkert) and [doowb](https://github.com/doowb), Enquirer is fast, easy to use, and lightweight enough for small projects, while also being powerful and customizable enough for the most advanced use cases.

* **Fast** - [Loads in ~4ms](#-performance) (that's about _3-4 times faster than a [single frame of a HD movie](http://www.endmemo.com/sconvert/framespersecondframespermillisecond.php) at 60fps_)
* **Lightweight** - Only one dependency, the excellent [ansi-colors](https://github.com/doowb/ansi-colors) by [Brian Woodward](https://github.com/doowb).
* **Easy to implement** - Uses promises and async/await and sensible defaults to make prompts easy to create and implement.
* **Easy to use** - Thrill your users with a better experience! Navigating around input and choices is a breeze. You can even create [quizzes](recipes/quiz.js), or [record](recipes/record.js) and [playback](recipes/play.js) keypresses to aid with tutorials and videos.
* **Intuitive** - Keypress combos are available to simplify usage.
* **Flexible** - All prompts can be used standalone or chained together.
* **Stylish** - Easily override semantic styles and symbols for any part of the prompt.
* **Extensible** - Easily create and use custom prompts by extending Enquirer's built-in [prompts](#-prompts).
* **Pluggable** - Add advanced features to Enquirer using plugins.
* **Validation** - Optionally validate user input with any prompt.
* **Well tested** - All prompts are well-tested, and tests are easy to create without having to use brittle, hacky solutions to spy on prompts or "inject" values.
* **Examples** - There are numerous [examples](examples) and [recipes](recipes) available to help you get started.

_(If you like Enquirer, you might also like [micromatch](https://github.com/micromatch/micromatch), created by [Jon Schlinkert](https://github.com/jonschlinkert), author of Enquirer)_.

<br>

<p align="center">
<b>Ready to start making prompts your users will love?</b><br>
<img src="https://github.com/enquirer/enquirer/raw/master/media/heartbeat.gif" alt="Enquirer Select Prompt with heartbeat example" width="750">
</p>

<br>
<br>
-->


<!--
## ❯ Install

Install with [npm](https://www.npmjs.com/):

```sh
$ npm install enquirer
```

<p align="center">
<img src="https://github.com/enquirer/enquirer/raw/master/media/npm-install.gif" alt="Install Enquirer with NPM" width="750">
</p>

_(Requires Node.js 8.6 or higher. Please let us know if you need support for an earlier version by creating an [issue](../../issues/new).)_

<br>

## ❯ Usage

### Single prompt
## ❯ Options

Each prompt takes an options object (aka "question" object), that implements the following interface:

```js
{
  // required
  type: string | function,
  name: string | function,
  message: string | function | async function,

  // optional 
  initial: string | function | async function
  format: function | async function,
  result: function | async function,
  validate: function | async function
}
```

### General options

All prompts take the following options.

| **Property** | **Required?** | **Type** | **Description** |
| --- | --- | --- | --- |
| `type`     | Yes | `string\|function` | Enquirer uses this value to determine the type of prompt to run, but it's optional when prompts are run directly. |
| `name`     | Yes | `string\|function` | Used as the key for the answer on the returned values (answers) object. |
| `message`  | Yes | `string\|function` | The message to display when the prompt is rendered in the terminal. |
| `initial`  | no | `string\|function` | The default value to return if the user does not supply a value. |
| `format`   | no | `function` | Function to format user input in the terminal. |
| `result`   | no | `function` | Function to format the final submitted value before it's returned. |
| `validate` | no | `function` | Function to validate the submitted value before it's returned. This function may return a boolean or a string. If a string is returned it will be used as the validation error message. |

**Example usage**

```js
const { prompt } = require('enquirer');

const question = {
  type: 'input',
  name: 'username',
  message: 'What is your username?'
};

prompt(question)
  .then(answer => console.log('Answer:', answer))
  .catch(console.error);
```

<br>

## ❯ Release History

Please see [CHANGELOG.md](CHANGELOG.md).

## ❯ Performance

MacBook Pro, Intel Core i7, 2.5 GHz, 16 GB.

### Load time

Time it takes for the module to load the first time (average of 3 runs):

```
enquirer: 4.013ms
inquirer: 286.717ms
```

<br>

## ❯ About -->
<!-- 
<details>
<summary><strong>Contributing</strong></summary>

Pull requests and stars are always welcome. For bugs and feature requests, [please create an issue](../../issues/new).

</details>

<details>
<summary><strong>Running Tests</strong></summary>

Running and reviewing unit tests is a great way to get familiarized with a library and its API. You can install dependencies and run tests with the following command:

```sh
$ npm install && npm test
```

</details>

<details>
<summary><strong>Building docs</strong></summary>

_(This project's readme.md is generated by [verb](https://github.com/verbose/verb-generate-readme), please don't edit the readme directly. Any changes to the readme must be made in the [.verb.md](.verb.md) readme template.)_

To generate the readme, run the following command:

```sh
$ npm install -g verbose/verb#dev verb-generate-readme && verb
```

</details>

### Contributors

| **Commits** | **Contributor** |  
| --- | --- |  
| 72 | [jonschlinkert](https://github.com/jonschlinkert) |  
| 12 | [doowb](https://github.com/doowb) |  
| 1  | [mischah](https://github.com/mischah) |  
| 1  | [skellock](https://github.com/skellock) |  

### Author

**Jon Schlinkert**

* [GitHub Profile](https://github.com/jonschlinkert)
* [Twitter Profile](https://twitter.com/jonschlinkert)
* [LinkedIn Profile](https://linkedin.com/in/jonschlinkert)

### Credit

Thanks to [derhuerst](https://github.com/derhuerst), creator of prompt libraries such as [prompt-skeleton](https://github.com/derhuerst/prompt-skeleton), which influenced some of the concepts we used in our prompts.

### License

Copyright © 2018, [Jon Schlinkert](https://github.com/jonschlinkert).
Released under the [MIT License](LICENSE). -->
