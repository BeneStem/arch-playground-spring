// eslint-disable-line max-lines

'use strict';

const fs = require('fs');
const path = require('path');
const appDirectory = fs.realpathSync(process.cwd()); // eslint-disable-line no-sync

const webpack = require('webpack');

const ModuleScopePlugin = require('react-dev-utils/ModuleScopePlugin');

const MiniCssExtractPlugin = require('mini-css-extract-plugin');
const FriendlyErrors = require('friendly-errors-webpack-plugin');
const CaseSensitivePathsPlugin = require('case-sensitive-paths-webpack-plugin');
const {CheckerPlugin, TsConfigPathsPlugin} = require('awesome-typescript-loader');
// const WatchMissingNodeModulesPlugin = require('react-dev-utils/WatchMissingNodeModulesPlugin');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
  mode: 'development',
  devtool: 'source-map',
  target: 'web',
  entry: {
    main: path.resolve(appDirectory, 'src/client/index.tsx')
  },
  output: {
    path: path.resolve(appDirectory, 'src/main/resources/static'),
    pathinfo: true,
    filename: 'js/[name].js',
    chunkFilename: 'js/[name].chunk.js',
    publicPath: './',
    devtoolModuleFilenameTemplate: (info) => {
      return path.relative(path.resolve(appDirectory, 'src/client'), info.absoluteResourcePath);
    }
  },
  resolve: {
    extensions: [
      '.ts',
      '.tsx',
      '.js',
      '.json',
      '.jsx'
    ],
    plugins: [
      new TsConfigPathsPlugin(),
      new ModuleScopePlugin(path.resolve(appDirectory, 'src/client'))
    ]
  },
  module: {
    strictExportPresence: true,
    rules: [
      {parser: {requireEnsure: false}},
      {
        test: /\.js$/,
        loader: 'source-map-loader',
        enforce: 'pre',
        include: path.resolve(appDirectory, 'src/client')
      },
      {
        exclude: [
          /\.html$/,
          /\.(js|jsx)$/,
          /\.(ts|tsx)$/,
          /\.css$/,
          /\.json$/,
          /\.bmp$/,
          /\.gif$/,
          /\.jpe?g$/,
          /\.png$/
        ],
        loader: 'file-loader',
        options: {
          name: 'media/[name].[hash:8].[ext]'
        }
      },
      {
        test: [
          /\.bmp$/,
          /\.gif$/,
          /\.jpe?g$/,
          /\.png$/
        ],
        loaders: [
          {
            loader: 'url-loader',
            options: {
              limit: 10000,
              name: 'media/[name].[hash:8].[ext]'
            }
          },
          {
            loader: 'image-webpack-loader',
            query: {
              progressive: true,
              optimizationLevel: 7,
              interlaced: false,
              mozjpeg: {
                quality: 75
              },
              pngquant: {
                quality: '65-90',
                speed: 4
              },
              svgo: {
                plugins: [
                  {
                    removeUnknownsAndDefaults: false
                  },
                  {
                    cleanupIDs: false
                  }
                ]
              },
              optipng: {
                optimizationLevel: 7
              },
              gifsicle: {
                optimizationLevel: 3
              }
            }
          }
        ]
      },
      {
        test: /\.(ts|tsx)$/,
        include: path.resolve(appDirectory, 'src/client'),
        loader: 'awesome-typescript-loader',
        options: {
          useBabel: true
        }
      },
      {
        test: /\.css$/,
        use: [
          MiniCssExtractPlugin.loader,
          {
            loader: 'css-loader',
            options: {
              sourceMap: true,
              modules: true,
              localIdentName: '[name]__[local]___[hash:base64:5]',
              importLoaders: 1
            }
          },
          {
            loader: 'postcss-loader',
            options: {
              plugins: () => {
                return [
                  require('postcss-import')(), // eslint-disable-line global-require
                  require('stylelint')(), // eslint-disable-line global-require
                  require('postcss-flexbugs-fixes'), // eslint-disable-line global-require
                  require('postcss-cssnext')({ // eslint-disable-line global-require
                    browsers: [
                      'last 2 versions',
                      'ie 9'
                    ],
                    flexbox: 'no-2009'
                  })
                ];
              }
            }
          }
        ]
      }
    ]
  },
  optimization: {
    splitChunks: {
      chunks: 'all'
    },
    runtimeChunk: true
  },
  plugins: [
    new webpack.DefinePlugin({
      'process.env': {
        NODE_ENV: '"development"'
      },
      DEBUG: true,
      __DEVTOOLS__: true
    }),
    new FriendlyErrors(),
    new CaseSensitivePathsPlugin(),
    new CheckerPlugin(),
    new webpack.NamedModulesPlugin(),
    // new WatchMissingNodeModulesPlugin(path.resolve(appDirectory, 'node_modules')),
    new webpack.NoEmitOnErrorsPlugin(),
    new MiniCssExtractPlugin({
      filename: 'css/[name].[contenthash:8].css'
    }),
    new HtmlWebpackPlugin({
      inject: true,
      template: path.resolve(appDirectory, 'src/client/resources/index.html')
    })
  ],
  node: {
    gram: 'empty',
    fs: 'empty',
    net: 'empty',
    tls: 'empty',
    child_process: 'empty'
  },
  performance: {
    hints: false
  }
};
